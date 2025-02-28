package View;

import Business.CustomerController;
import Business.ProductController;
import Core.ComboBoxItem;
import Core.Helper;
import Entity.Customer;
import Entity.Product;
import Entity.User;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DashboardUI extends JFrame {
    private JButton btn_exit;
    private JPanel pnl_main;
    private JLabel lbl_welcome;
    private JTabbedPane pnl_customer;
    private JPanel pnl_tapped_customer;
    private JTable tbl_customer;
    private JComboBox cmb_customer_type;
    private JButton btn_customer_filter;
    private JButton btn_customer_clear;
    private JButton btn_customer_add;
    private JLabel lbl_customer_filter;
    private JTextField fld_customer_name;
    private JLabel lbl_customer_type;
    private JPanel pnl_product;
    private JScrollPane scroll_customer;
    private JScrollPane scroll_product;
    private JTable tbl_product;
    private JPanel pnl_middle_product;
    private JLabel lbl_filter_product;
    private JTextField fld_product_name;
    private JLabel lbl_product_code;
    private JTextField fld_product_code;
    private JLabel lbl_isStock;
    private JComboBox<ComboBoxItem> cmb_isStock;
    private JButton btn_product_filter;
    private JButton btn_product_clear;
    private JButton btn_product_add;
    private User user;
    private final CustomerController customerController = new CustomerController();
    private final ProductController productController = new ProductController();
    private DefaultTableModel table_model_customer = new DefaultTableModel();
    private DefaultTableModel table_model_product = new DefaultTableModel();
    private JPopupMenu popup_customer_selection = new JPopupMenu();
    private JPopupMenu popup_product_selection = new JPopupMenu();

    public DashboardUI(User user) {
        this.user = user;


        setContentPane(pnl_main);
        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1500, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // init table
        loadCustomerTable(null);
        loadProductTable(null);
        loadCustomerPopUpMenu();
        loadProductPopUpMenu();
        loadCustomerButtons();
        loadProductButtons();
        // init table


        // CUSTOMER  TAB

        this.cmb_customer_type.setModel(new DefaultComboBoxModel<>(Customer.ETYPE.values()));
        this.cmb_customer_type.setSelectedItem(null);


        this.lbl_welcome.setText("Welcome Back " + this.user.getName());
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginUI loginUI = new LoginUI();
            }
        });


        // PRODUCT TAB
        this.cmb_isStock.addItem(new ComboBoxItem(1, "In Stock"));
        this.cmb_isStock.addItem(new ComboBoxItem(2, "Out Stock"));
        this.cmb_isStock.setSelectedItem(null);



    }


    // CUSTOMER Functions

    private void loadCustomerButtons() {

        this.btn_customer_add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerUI customerUI = new CustomerUI(new Customer());
                customerUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadCustomerTable(null);
                    }
                });
            }
        });

        btn_customer_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fld_customer_name.setText(null);
                cmb_customer_type.setSelectedItem(null);
                loadCustomerTable(null);
            }
        });

        btn_customer_filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Customer> arrayList = new ArrayList<>();
                arrayList = customerController.filter(fld_customer_name.getText(), cmb_customer_type.getSelectedItem().toString());
                loadCustomerTable(arrayList);
            }
        });

    }

    private void loadCustomerPopUpMenu() {
        this.tbl_customer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tbl_customer.rowAtPoint(e.getPoint());
                tbl_customer.setRowSelectionInterval(selectedRow, selectedRow);
            }

        });

        this.popup_customer_selection.add("Update").addActionListener(e -> {
            String selectedID = tbl_customer.getValueAt(tbl_customer.getSelectedRow(), 0).toString();

            Customer editedCustomer = customerController.findById(selectedID);

            CustomerUI customerUI = new CustomerUI(editedCustomer);
            customerUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCustomerTable(null);
                }
            });

        });
        this.popup_customer_selection.add("Delete").addActionListener(e -> {
            String selectedID = tbl_customer.getValueAt(tbl_customer.getSelectedRow(), 0).toString();
            if (Helper.confirmDelete("sure_customer")) {

                Customer deletedCustomer = customerController.findById(selectedID);
                customerController.delete(deletedCustomer);
                loadCustomerTable(null);
            }


        });
        this.tbl_customer.setComponentPopupMenu(popup_customer_selection);
    }


    private void loadCustomerTable(ArrayList<Customer> customers) {
        Object[] columnCustomer = {"ID", "Name", "Address", "Phone", "Email", "Type"};
        this.table_model_customer.setColumnIdentifiers(columnCustomer);


        // Clearing Table
        DefaultTableModel clearModel = (DefaultTableModel) this.tbl_customer.getModel();
        clearModel.setRowCount(0);
        // Clearing Table


        ArrayList<Customer> customersFetched = new ArrayList<>();
        if (customers == null) {
            customersFetched = customerController.findAll();
        } else
            customersFetched = customers;


        for (Customer customer : customersFetched) {
            this.table_model_customer.addRow(new Object[]{
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getPhone(),
                    customer.getMail(),
                    customer.getType(),
            });
        }
        this.tbl_customer.setModel(this.table_model_customer);
        this.tbl_customer.getTableHeader().setReorderingAllowed(false);
        this.tbl_customer.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tbl_customer.setEnabled(false);

    }


    // PRODUCT Functions

    private void loadProductTable(ArrayList<Product> products) {
        Object[] columnProduct = {"ID", "Name", "Code", "Price", "Stock"};
        this.table_model_product.setColumnIdentifiers(columnProduct);


        // Clearing Table
        DefaultTableModel clearModel = (DefaultTableModel) this.tbl_product.getModel();
        clearModel.setRowCount(0);
        // Clearing Table


        ArrayList<Product> productsFetched = new ArrayList<>();
        if (products == null) {
            productsFetched = productController.findAll();
        } else
            productsFetched = products;


        for (Product product : productsFetched) {
            this.table_model_product.addRow(new Object[]{
                    product.getId(),
                    product.getName(),
                    product.getCode(),
                    product.getPrice(),
                    product.getStock()
            });
            System.out.println(product);
        }
        this.tbl_product.setModel(this.table_model_product);
        this.tbl_product.getTableHeader().setReorderingAllowed(false);
        this.tbl_product.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tbl_product.setEnabled(false);

    }


    private void loadProductPopUpMenu() {
        this.tbl_product.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tbl_product.rowAtPoint(e.getPoint());
                tbl_product.setRowSelectionInterval(selectedRow, selectedRow);
            }

        });

        this.popup_product_selection.add("Update").addActionListener(e -> {
            String selectedID = tbl_product.getValueAt(tbl_product.getSelectedRow(), 0).toString();

            Product editedProduct = productController.findById(selectedID);


            ProductUI productUI = new ProductUI(editedProduct);
            productUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadProductTable(null);
                }
            });


        });
        this.popup_product_selection.add("Delete").addActionListener(e -> {
            String selectedID = tbl_product.getValueAt(tbl_product.getSelectedRow(), 0).toString();
            if (Helper.confirmDelete("sure_product")) {

                Product deletedProduct = productController.findById(selectedID);
                productController.delete(deletedProduct);
                loadProductTable(null);
            }


        });
        this.tbl_product.setComponentPopupMenu(popup_product_selection);
    }


    private void loadProductButtons() {
        this.btn_product_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ProductUI productUI = new ProductUI(new Product());
                productUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadProductTable(null);
                    }
                });


            }
        });


        btn_product_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fld_product_name.setText(null);
                fld_product_code.setText(null);
                cmb_isStock.setSelectedItem(null);
                loadProductTable(null);
            }
        });


        this.btn_product_filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComboBoxItem item = (ComboBoxItem) cmb_isStock.getSelectedItem();
                int stock = -1;
                if(item != null)
                    stock = item.getKey();

                ArrayList<Product> products = productController.filter(fld_product_name.getText(),fld_product_code.getText(),stock);
                loadProductTable(products);
            }
        });
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        pnl_main = new JPanel();
        pnl_main.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        pnl_main.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        lbl_welcome = new JLabel();
        lbl_welcome.setText("Label");
        panel1.add(lbl_welcome, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn_exit = new JButton();
        btn_exit.setHorizontalAlignment(0);
        btn_exit.setText("Exit");
        panel1.add(btn_exit, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pnl_customer = new JTabbedPane();
        pnl_main.add(pnl_customer, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        pnl_tapped_customer = new JPanel();
        pnl_tapped_customer.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        pnl_customer.addTab("Customer", pnl_tapped_customer);
        scroll_customer = new JScrollPane();
        pnl_tapped_customer.add(scroll_customer, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tbl_customer = new JTable();
        scroll_customer.setViewportView(tbl_customer);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(2, 5, new Insets(5, 5, 5, 5), -1, -1, true, false));
        pnl_tapped_customer.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        lbl_customer_filter = new JLabel();
        lbl_customer_filter.setText("Customer Name");
        panel2.add(lbl_customer_filter, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbl_customer_type = new JLabel();
        lbl_customer_type.setText("Customer Type");
        panel2.add(lbl_customer_type, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cmb_customer_type = new JComboBox();
        panel2.add(cmb_customer_type, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn_customer_filter = new JButton();
        btn_customer_filter.setText("Filter");
        panel2.add(btn_customer_filter, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn_customer_clear = new JButton();
        btn_customer_clear.setText("Clear");
        panel2.add(btn_customer_clear, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn_customer_add = new JButton();
        btn_customer_add.setText("Add");
        panel2.add(btn_customer_add, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fld_customer_name = new JTextField();
        panel2.add(fld_customer_name, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pnl_product = new JPanel();
        pnl_product.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        pnl_customer.addTab("Product", pnl_product);
        scroll_product = new JScrollPane();
        pnl_product.add(scroll_product, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tbl_product = new JTable();
        scroll_product.setViewportView(tbl_product);
        pnl_middle_product = new JPanel();
        pnl_middle_product.setLayout(new GridLayoutManager(2, 6, new Insets(5, 5, 5, 5), -1, -1, true, false));
        pnl_product.add(pnl_middle_product, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        lbl_filter_product = new JLabel();
        lbl_filter_product.setText("Filter");
        pnl_middle_product.add(lbl_filter_product, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fld_product_name = new JTextField();
        pnl_middle_product.add(fld_product_name, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lbl_product_code = new JLabel();
        lbl_product_code.setText("Code");
        pnl_middle_product.add(lbl_product_code, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fld_product_code = new JTextField();
        pnl_middle_product.add(fld_product_code, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lbl_isStock = new JLabel();
        lbl_isStock.setText("Stock");
        pnl_middle_product.add(lbl_isStock, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cmb_isStock = new JComboBox();
        pnl_middle_product.add(cmb_isStock, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn_product_filter = new JButton();
        btn_product_filter.setText("Filter");
        pnl_middle_product.add(btn_product_filter, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn_product_clear = new JButton();
        btn_product_clear.setText("Clear");
        pnl_middle_product.add(btn_product_clear, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn_product_add = new JButton();
        btn_product_add.setText("Add");
        pnl_middle_product.add(btn_product_add, new GridConstraints(1, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pnl_main;
    }

}
