package interprete;

import checker.MethodsTable;

import java.util.LinkedList;


public class DataStorage {

    private LinkedList<Value> data;
    private int actualIndex;
    private int actualLevel;

    public class Value{
        String name;
        Object value;
        int index;
        int level;
        public Value(String name, Object value, int index) {
            this.name = name;
            this.value = value;
            this.index = index;
            this.level = actualLevel;
        }
    }

    public DataStorage()
    {
        this.data = new LinkedList<Value>();
        this.actualIndex = 0;
        this.actualLevel = 0;
    }



    public void addData(String name, Object value) {
        Value v = new Value(name,value,this.actualIndex);
        this.data.add(v);
        this.actualIndex++;
    }


    public void openScope()
    {
        this.actualLevel++;
    }

    public void closeScope( )
    {
        if(!this.data.isEmpty()) {
            Value element = data.getLast();
            while (!data.isEmpty() && element.level == actualLevel) {
                data.removeLast();
                element = data.getLast();
                this.actualIndex--;
            }
            this.actualLevel--;
            return;
        }
        this.actualLevel--;
    }

    public Value getData(int index) {
        return this.data.get(index);
    }

    public Value getData(String name){
        int length = this.data.size()-1;
        while (length>=0)
        {
            if(data.get(length).name.equals(name))
            {
                return data.get(length);
            }
            length--;
        }
        return null;
    }

    public void print() {
        System.out.println("\nData storage state:\n");
        if(!this.data.isEmpty())
        {
            for (Value i : this.data) {
                System.out.println(i.name +"="+i.value.toString());

            }
        }
    }

    public int getActualStorageIndex(){
        return this.actualIndex;
    }
    public LinkedList<Value> getData() {
        return this.data;
    }

    public int getActualLevel() {
        return actualLevel;
    }
}
