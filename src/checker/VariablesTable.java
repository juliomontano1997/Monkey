/**
 * This is only a test
 * */
package checker;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.LinkedList;

public class VariablesTable {

    private LinkedList<VariablesTable.Element> table;
    private int actualLevel;

    public class Element
    {
        int level;
        Token token;
        int type;
        ParserRuleContext context;


        public Element(int level, Token token, int type, ParserRuleContext context) {
            this.level = level;
            this.token = token;
            this.type = type;  // Data type none, int, string, boolean.
            this.context = context;
        }

        public String toString()
        {
            return this.token.getText() + ", " + this.level;
        }
    }

    public VariablesTable()
    {
        this.table = new LinkedList<VariablesTable.Element>();
        this.actualLevel = 0;
    }

    public VariablesTable.Element insert(String name, int type,ParserRuleContext context)
    {
        Token newToken = new CommonToken(0,name);
        VariablesTable.Element newElement = new   VariablesTable.Element(actualLevel,newToken,type,context);

        System.out.println("No se ha caído");
        int actualPosition = 0;
        while (actualPosition < this.table.size() && this.table.get(actualPosition).level == actualLevel)
        {
            if (this.table.get(actualPosition).token.getText().equals(name))
            {
                System.out.println("Variable \"" + name + "\" already exist!!!");
                return null;
            }
            actualPosition++;
        }
        this.table.push(newElement);
        return this.table.get(0);
    }



    public void openScope()
    {
        this.actualLevel++;
    }

    public void closeScope(){
        VariablesTable.Element element = this.table.get(0);
        while (element != null && element.level == actualLevel){
            table.pop();
            if(!this.table.isEmpty())
                element = this.table.get(0);
            else
                element = null;
        }
        this.actualLevel--;
    }

    public VariablesTable.Element search(String name)
    {
        VariablesTable.Element temp = null;
        for(VariablesTable.Element element : this.table)
        {
            if (element.token.getText().equals(name))
            {
                temp = element;
                break;
            }
        }
        return temp;
    }

    public void print() {
        System.out.println(" ----------------------   Table state   ---------------------------");
        if (!this.table.isEmpty()) {
            for (VariablesTable.Element i : this.table) {
                String nivel = "";
                for (int j = 0; j < i.level; j++) {
                    nivel += "\t";
                }
                System.out.println(nivel  + "  "+ i.token.getText() +"  "+ i.type );
            }
        }
        else
            System.out.println("Empty table");
    }
    public LinkedList<VariablesTable.Element> getTable() {
        return this.table;
    }
}
