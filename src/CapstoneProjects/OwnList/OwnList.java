package CapstoneProjects.OwnList;

public class OwnList<T> {

    private int SIZE;
    private Object[] list;
    private int index;

    // NoArgsConstructor
    public OwnList(){
        this.SIZE = 10;
        this.list = new Object[SIZE];
        this.index = 0;
    }
    public OwnList(int size){
        this.SIZE = size;
        this.list = new Object[SIZE];
        this.index = 0;
    }

    // returns the number of element in array
    public int getSize(){
        return index;
    }

    // decreasing or increasing size
    public void setSize(int amount){
        this.index +=amount;
    }

    // Returns the maximum number of elements that can be present in the array at that moment.
    public int getCapacity(){
        return SIZE;
    }


    public void add(T data){
        if(getSize()==getCapacity()){
            SIZE *=2;
            Object[] temp = new Object[SIZE];
            for(int i = 0; i < SIZE/2; i++){
                temp[i] = list[i];
            }
            list = temp;
        }
        list[getSize()] = data;
        index++;
    }

    public T get(int index){
        if(index<0 || index>= getSize())
            return null;
        return (T) list[index];
    }

    // Clearing with override
    //In other words, element deletion is done by overriding.

    public T remove(int index){
        T data;
        if(index<0 || index>=getSize())
            return null;
        data = (T) list[index];
        for(int i = index+1; i<getCapacity(); i++){
            list[i-1]  = list[i];
        }
        list[getSize() - 1] = null;
        setSize(-1);
        return data;
    }

    public T set(int index, T data){
        if(index<0 || index>= getSize())
            return null;
        list[index] = data;
        return data;
    }

    @Override
    public String toString(){
        String rValue ="";
        //System.out.println(index);

        rValue+="[ ";
        for(int i = 0; i < getSize(); i++){

            rValue+= get(i)+", ";
        }
        rValue+="] ";
        //System.out.println(rValue);
        return rValue;
    }

    public boolean contains(T data){
        for(int i = 0; i < getSize(); i++){
            if(data.equals(get(i)))
                return true;
        }
        return false;
    }


    public OwnList<T> sublist(int start, int end){
        if(start<0 || end<0)
            return null;
        if(start>=getSize() || end>=getSize())
            return null;
        int size = (end-start)+1;
        OwnList<T> rValue = new OwnList<>(size);
        for(int i=start; i<=end; i++){
            rValue.add(get(i));
        }
        return rValue;
    }

    //All elements in the array's capacity are converted to null.
    public void clear (){
        for(int i = 0; i < SIZE; i++){
            list[i] = null;
        }
        index = 0;
    }

    public boolean isEmpty(){
        if(getSize()==0)
            return true;
        return false;
    }

    public int indexOf(T data){
        for(int i = 0; i < getSize(); i++){
            if(data.equals(get(i)))
                return i;
        }
        return -1;
    }

    public Object[] toArray(){

        Object [] rValue = new Object[getSize()];
        for(int i = 0; i < getSize(); i++){
            rValue[i] = get(i);
        }
        return rValue;
    }

    public int lastIndexOf(T data){
        for(int i = getSize()-1; i >= 0; i--){
            if(data.equals(get(i)))
                return i;
        }
        return -1;
    }

}
