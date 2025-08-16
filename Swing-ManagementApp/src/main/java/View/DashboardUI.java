package View;

import Business.BasketController;
import Business.CartController;
import Business.CustomerController;
import Business.ProductController;
import Core.ComboBoxBasketItem;
import Core.ComboBoxItem;
import Core.Helper;
import Entity.*;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;

public class DashboardUI extends JFrame {
    private JButton btn_exit;
    private JPanel pnl_main;
    private JLabel lbl_welcome;
    private JTabbedPane pnl_orders;
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
    private JPanel pnl_basket;
    private JPanel pnl_basket_top;
    private JScrollPane scroll_basket;
    private JComboBox<ComboBoxBasketItem> cmb_basket_customers;
    private JButton btn_basket_clear;
    private JButton btn_basket_create;
    private JLabel lbl_basket_customer_name;
    private JLabel lbl_basket_total_price;
    private JLabel lbl_basket_price;
    private JLabel lbl_product_number;
    private JTable tbl_basket;
    private JLabel lbl_basket_count;
    private JScrollPane scroll_orders;
    private JTable tbl_orders;
    private User user;
    private Basket basket = new Basket();
    private final CustomerController customerController = new CustomerController();
    private final ProductController productController = new ProductController();
    private final BasketController basketController = new BasketController();
    private final CartController cartController = new CartController();
    private DefaultTableModel table_model_customer = new DefaultTableModel();
    private DefaultTableModel table_model_basket = new DefaultTableModel();
    private DefaultTableModel table_model_product = new DefaultTableModel();
    private DefaultTableModel table_model_orders = new DefaultTableModel();
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
        loadBasketTable();
        loadOrdersTable();
        loadCustomerPopUpMenu();
        loadProductPopUpMenu();
        loadCustomerButtons();
        loadProductButtons();
        loadBasketCustomers();
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


        btn_basket_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                basket.set_id(null);
                loadBasketTable();
            }
        });
        btn_basket_create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ComboBoxBasketItem item = (ComboBoxBasketItem) cmb_basket_customers.getSelectedItem();
                    String customerId = item.getId();
                    Customer customer = customerController.findById(customerId);
                    ArrayList<Product> products = basketController.findBasket(basket.get_id());
                    System.out.println(products);
                    if (products.isEmpty() == true) {
                        Helper.showMessage("CART_EMPTY");
                    } else {
                        CartUI cart = new CartUI(customer, basket);
                        cart.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                basket.set_id(null);
                                loadBasketTable();
                                loadProductTable(null);
                                loadOrdersTable();


                            }
                        });
                    }
                } catch (NullPointerException ex) {
                    Helper.showMessage("CART_SELECT_CUSTOMER");
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
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
                        loadBasketCustomers();
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
                    loadBasketCustomers();
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

            loadBasketCustomers();

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
                    loadBasketTable();
                }
            });


        });

        this.popup_product_selection.add("Add Cart").addActionListener(e -> {
            String selectedID = tbl_product.getValueAt(tbl_product.getSelectedRow(), 0).toString();

            Product fetchedProduct = productController.findById(selectedID);

            int stock = fetchedProduct.getStock();

            if (stock <= 0)
                Helper.showMessage("PRODUCT_STOCK_INSUFFICIENT");
            else {

                this.basket.setProduct(fetchedProduct);

                String result = basketController.save(this.basket);
                basket.set_id(result);

                //DEBUG:check basket id
                //System.out.println("Basket Id-> " + this.basket.get_id());

                loadBasketTable();


                if (result != null) {
                    Helper.showMessage("ADD_CART_SUCCESS");
                } else {
                    Helper.showMessage("ADD_CART_FAIL");
                }


            }



        });

        this.popup_product_selection.add("Delete").addActionListener(e -> {
            String selectedID = tbl_product.getValueAt(tbl_product.getSelectedRow(), 0).toString();
            if (Helper.confirmDelete("sure_product")) {

                Product deletedProduct = productController.findById(selectedID);
                productController.delete(deletedProduct);
                loadProductTable(null);
                loadBasketTable();
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
                if (item != null)
                    stock = item.getKey();

                ArrayList<Product> products = productController.filter(fld_product_name.getText(), fld_product_code.getText(), stock);
                loadProductTable(products);
            }
        });
    }


    // BASKET TAB

    // BASKET FUNC

    private void loadBasketTable() {
        Object[] columnBasket = {"ID", "Name", "Code", "Price", "Stock"};
        this.table_model_basket.setColumnIdentifiers(columnBasket);
        int totalPrice = 0;

        // Clearing Table
        DefaultTableModel clearModel = (DefaultTableModel) this.tbl_basket.getModel();
        clearModel.setRowCount(0);
        // Clearing Table
        ArrayList<Product> products;
        if (basket.get_id() == null)
            products = null;
        else {
            products = basketController.findBasket(this.basket.get_id());

            for (Product product : products) {
                this.table_model_basket.addRow(new Object[]{
                        product.getId(),
                        product.getName(),
                        product.getCode(),
                        product.getPrice(),
                        product.getStock()
                });

                totalPrice += product.getPrice();
            }

        }

        //DEBUG:check baskets
        //System.out.println("Baskets-> " + products);

        this.lbl_basket_price.setText(totalPrice + " TL");
        this.lbl_basket_count.setText((products == null) ? "0 Item" : products.size() + " Item");

        this.tbl_basket.setModel(this.table_model_basket);
        this.tbl_basket.getTableHeader().setReorderingAllowed(false);
        this.tbl_basket.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tbl_basket.setEnabled(false);
    }


    private void loadBasketCustomers() {
        ArrayList<Customer> customers = customerController.findAll();

        this.cmb_basket_customers.removeAllItems();
        for (Customer customer : customers) {
            this.cmb_basket_customers.addItem(new ComboBoxBasketItem(customer.getId(), customer.getName()));
        }

        this.cmb_basket_customers.setSelectedItem(null);
    }


    // ORDER TAB


    private void loadOrdersTable() {

        Object[] columnOrders= {"ID", "Customer Name", "Product Name", "Price", "Date" ,"Note"};
        this.table_model_orders.setColumnIdentifiers(columnOrders);

        // Clearing Table
        DefaultTableModel clearModel = (DefaultTableModel) this.tbl_orders.getModel();
        clearModel.setRowCount(0);
        // Clearing Table

        ArrayList<Cart> orders= cartController.findAll();

        for (Cart cart : orders) {
            for (Product product : cart.getProducts()) { //  Create a separate row for each product
                this.table_model_orders.addRow(new Object[]{
                        cart.getId(),
                        cart.getCustomer().getName(),
                        product.getName(),
                        product.getPrice(),
                        cart.getDate(),
                        cart.getNote()
                });
            }
        }

        this.tbl_orders.setModel(this.table_model_orders);
        this.tbl_orders.getTableHeader().setReorderingAllowed(false);
        this.tbl_orders.getColumnModel().getColumn(0).setMaxWidth(50);
        this.tbl_orders.setEnabled(false);

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
        pnl_orders = new JTabbedPane();
        pnl_main.add(pnl_orders, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        pnl_tapped_customer = new JPanel();
        pnl_tapped_customer.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        pnl_orders.addTab("Customer", pnl_tapped_customer);
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
        pnl_orders.addTab("Product", pnl_product);
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
        pnl_basket = new JPanel();
        pnl_basket.setLayout(new GridLayoutManager(3, 6, new Insets(0, 0, 0, 0), -1, -1));
        pnl_orders.addTab("Create Order", pnl_basket);
        pnl_basket_top = new JPanel();
        pnl_basket_top.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        pnl_basket.add(pnl_basket_top, new GridConstraints(2, 0, 1, 6, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        scroll_basket = new JScrollPane();
        pnl_basket_top.add(scroll_basket, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tbl_basket = new JTable();
        scroll_basket.setViewportView(tbl_basket);
        lbl_basket_customer_name = new JLabel();
        lbl_basket_customer_name.setText("Select a Customer");
        pnl_basket.add(lbl_basket_customer_name, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbl_basket_total_price = new JLabel();
        lbl_basket_total_price.setText("Total Price");
        pnl_basket.add(lbl_basket_total_price, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cmb_basket_customers = new JComboBox();
        pnl_basket.add(cmb_basket_customers, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbl_basket_price = new JLabel();
        lbl_basket_price.setText("0 TL");
        pnl_basket.add(lbl_basket_price, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn_basket_clear = new JButton();
        btn_basket_clear.setText("Clear");
        pnl_basket.add(btn_basket_clear, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btn_basket_create = new JButton();
        btn_basket_create.setText("Create Order");
        pnl_basket.add(btn_basket_create, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbl_product_number = new JLabel();
        lbl_product_number.setText("Product Number");
        pnl_basket.add(lbl_product_number, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbl_basket_count = new JLabel();
        lbl_basket_count.setText("0 Item");
        pnl_basket.add(lbl_basket_count, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        pnl_orders.addTab("Orders", panel3);
        scroll_orders = new JScrollPane();
        panel3.add(scroll_orders, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tbl_orders = new JTable();
        scroll_orders.setViewportView(tbl_orders);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pnl_main;
    }

}
