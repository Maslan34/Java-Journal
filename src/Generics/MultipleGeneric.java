package Generics;

public class MultipleGeneric <M,H,Y>{

    private M field1;
    private H field2;
    private Y field3;

    public MultipleGeneric(M obj1, H obj2, Y obj3) {
        this.field1 = obj1;
        this.field2 = obj2;
        this.field3 = obj3;
    }


    public M getField1() {
        return field1;
    }

    public void setField1(M field1) {
        this.field1 = field1;
    }

    public H getField2() {
        return field2;
    }

    public void setField2(H field2) {
        this.field2 = field2;
    }

    public Y getField3() {
        return field3;
    }

    public void setField3(Y field3) {
        this.field3 = field3;
    }


    public void ShowInfo(){
        System.out.println(
             "Field1: "+this.field1 +" its class-> "+this.field1.getClass().getSimpleName()+"\n"+
                     "Field2: "+this.field2 +" its class-> "+this.field2.getClass().getSimpleName()+"\n"+
                        "Field3: "+this.field3 +" its class-> "+this.field3.getClass().getSimpleName()+"\n"

        );
    }

    public static void iterateGenerics(MultipleGeneric obj1){

        if(obj1.field2 instanceof Integer[]){
            for(Integer i : (Integer[]) obj1.field2){
                System.out.println(i);
            }
        }

    }


    public  <M,H,Y> void iterateGenericsWithoutClassObject(M[] iterable1, H[] iterable2, Y[] iterable3){

        System.out.println("iterable1 elemanları:");
        for (M item : iterable1) {
            System.out.println(item);
        }

        System.out.println("\niterable2 elemanları:");
        for (H item : iterable2) {
            System.out.println(item);
        }

        System.out.println("\niterable3 elemanları:");
        for (Y item : iterable3) {
            System.out.println(item);
        }

    }
}
