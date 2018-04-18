package checker;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import java.util.LinkedList;

public class VariableSymbolsTable {

    private LinkedList<Ident> table;
    private int actualLevel;

    public class Ident
    {
        int level;
        Token tok;
        int type;
        String form; //var || (array - hashLiteral)
        ParserRuleContext decl;

        public Ident(int l, Token t, int ty, String f, ParserRuleContext d) {
            level = l;
            tok = t;
            type = ty;
            form = f;
            decl = d;
        }
        public String toString(){
            return this.tok.getText() + ", " + this.level;
        }
    }

    public VariableSymbolsTable()
    {
        this.actualLevel = 0;
        this.table = new LinkedList<Ident>();
    }

    public Ident insert(String n, int t, String f, ParserRuleContext d)
    {
        Token tk = new CommonToken(0,n);
        Ident i = new Ident(actualLevel,tk,t,f,d);
        int j = 0;
        while (j < this.table.size() && this.table.get(j).level == actualLevel) {
            if (this.table.get(j).tok.getText().equals(n)) {
                System.out.println("Variable \"" + n + "\" already exist!!!");
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
        Ident element = this.table.get(0);
        while (element != null && element.level == actualLevel){
            table.pop();
            if(!this.table.isEmpty())
                element = this.table.get(0);
            else
                element = null;
        }
        this.actualLevel--;
    }

    public Ident search(String name)
    {
        Ident temp = null;
        for(Ident id : this.table)
            if (id.tok.getText().equals(name)) {
                temp = id;
                break;
            }
        return temp;
    }

    public void print() {
        System.out.println("****** SYMBOLS TABLE STATE ******");
        if (!this.table.isEmpty()) {
            for (Ident i : this.table) {
                String nivel = "";
                for (int j = 0; j < i.level; j++) {
                    nivel += "\t";
                }
                System.out.println(nivel + "Name: " + i.tok.getText() + ", "
                                         + "Level: " + i.level);
            }
            System.out.println("------------------------------------------");
        }
        else
            System.out.println("Empty table");
    }
    public LinkedList<Ident> getTable() {
        return this.table;
    }



}
