public class ArrayList implements List {

    private Object Array[];
    private int size =0;
    ArrayList(){
        Array= new Object[10];
    }
    @Override
    public void add(Object obj) {
        if (Array.length == size){
            growArray();
        }
        Array[size]= obj;
        ++size;
    }

    @Override
    public void add(int pos, Object obj) {
        if(pos<0 || pos>size){
            try {
                throw new Exception();
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
        if(Array.length == size){
            growArray();
        }
        for(int i=size;i>pos;i--){//shifts objects over until we reach index where we put the object in.
            Array[i]=Array[i-1];
        }
        size++;
        Array[pos]=obj;
    }

    @Override
    public Object get(int pos) {
        if(pos<0 || pos>size){
            try {
                throw new Exception();
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
        return Array[pos];
    }

    @Override
    public Object remove(int pos) {
        if(pos<0 || pos>=size){
            try {
                throw new Exception();
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
        Object obj = Array[pos];
        for(int i=pos;i<size-1;i++){//shifts everything back starting from the removed object.
            Array[i]=Array[i+1];
        }
        --size;
        return obj;
    }

    @Override
    public int size() {
        return size;
    }

    private void growArray(){
        Object temp[]= new Object[size*2];
        for(int i=0;i<size;i++){
            temp[i]=Array[i];
        }
        Array = temp;
    }
}
