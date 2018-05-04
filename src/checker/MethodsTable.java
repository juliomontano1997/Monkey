package checker;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import java.util.LinkedList;

public class MethodsTable {

    private LinkedList<MethodsTable.Element> table;
    private int actualLevel;

    public class Element{
        int level;
        Token token;
        int numberParams;
        int returnType;
        ParserRuleContext context;

        //Se deben inicializar los metodos en la tabla.


        public Element(int level, Token token, int numberParams, int returnType, ParserRuleContext context) {
            this.level = level;
            this.token = token;
            this.numberParams = numberParams;
            this.returnType = returnType;
            this.context = context;
        }

        public String toString(){
            return this.token.getText() + ", " + this.numberParams + ", "+ this.returnType + ", " +this.level;
        }

        public int getNumberParams() {
            return numberParams;
        }

        public void setNumberParams(int numberParams) {
            this.numberParams = numberParams;
        }
    }

    public MethodsTable()
    {
        this.table = new LinkedList<>();
        this.actualLevel = 0;
    }


    public MethodsTable.Element insert(String name, int paramsNumber, int returnType, ParserRuleContext context)
    {
        Token newToken = new CommonToken(0,name);
        MethodsTable.Element i = new MethodsTable.Element(actualLevel,newToken,paramsNumber,returnType,context);
        int j = 0;
        while (j < this.table.size() && this.table.get(j).level == actualLevel) {
            if (this.table.get(j).token.getText().equals(name)) {
                System.out.println("Function \"" + name + "\" already exist!!!");
                return null;
            }
            j++;
        }
        this.table.push(i);
        return this.table.get(0);
    }


    public void openScope(){
        this.actualLevel++;
    }

    public void closeScope(){
        MethodsTable.Element element = this.table.get(0);
        while (element != null && element.level == actualLevel){
            table.pop();
            if(!this.table.isEmpty())
                element = this.table.get(0);
            else
                element = null;
        }
        this.actualLevel--;
    }

    public MethodsTable.Element search(String name)
    {
        MethodsTable.Element temp = null;
        for(MethodsTable.Element element : this.table)
            if (element.token.getText().equals(name)) {
                temp = element;
                break;
            }
        return temp;
    }

    public void print() {
        System.out.println("****** SYMBOLS TABLE STATE ******");
        if (!this.table.isEmpty()) {
            for (MethodsTable.Element i : this.table) {
                String nivel = "";
                for (int j = 0; j < i.level; j++) {
                    nivel += "\t";
                }
                System.out.println(nivel + "Name: " + i.token.getText() + ", "
                                         + "Number of parameters: " + i.numberParams + ", "
                                         + "Return type: " + i.returnType + ", "
                                         + "Level: " + i.level);
            }
            System.out.println("------------------------------------------");
        }
        else
            System.out.println("Empty table");
    }

    public LinkedList<MethodsTable.Element> getTable() {
        return this.table;
    }





}
