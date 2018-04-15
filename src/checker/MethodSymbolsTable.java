package checker;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import java.util.LinkedList;

public class MethodSymbolsTable {

    private LinkedList<MethodSymbolsTable.Ident> table;
    private int actualLevel;

    public class Ident{
        int level;
        Token tok;
        int numberParams;
        LinkedList<Integer> paramsType;
        int returnType;
        ParserRuleContext decl;

        public Ident(int l, Token t, int nP, LinkedList<Integer> pT, int rT, ParserRuleContext d) {
            level = l;
            tok = t;
            numberParams = nP;
            paramsType = pT;
            returnType = rT;
            decl = d;
        }

        public String toString(){
            return this.tok.getText() + ", " + this.numberParams + ", " + this.paramsType.toString() + ", "+ this.returnType + ", " +this.level;
        }
    }

    public MethodSymbolsTable()
    {
        this.actualLevel = 0;
        this.table = new LinkedList<MethodSymbolsTable.Ident>();
    }

    public MethodSymbolsTable.Ident insert(String n, int nP, LinkedList<Integer> pT, int rT, ParserRuleContext d)
    {
        Token tk = new CommonToken(0,n);
        MethodSymbolsTable.Ident i = new MethodSymbolsTable.Ident(actualLevel,tk,nP,pT,rT,d);
        int j = 0;
        while (j < this.table.size() && this.table.get(j).level == actualLevel) {
            if (this.table.get(j).tok.getText().equals(n) && this.table.get(j).numberParams == nP && this.table.get(j).returnType == rT && this.table.get(j).paramsType == pT) {
                System.out.println("Function \"" + n + "\" already exist!!!");
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
        MethodSymbolsTable.Ident element = this.table.get(0);
        while (element != null && element.level == actualLevel){
            table.pop();
            if(!this.table.isEmpty())
                element = this.table.get(0);
            else
                element = null;
        }
        this.actualLevel--;
    }

    public MethodSymbolsTable.Ident search(String name, int amountParams, LinkedList<Integer> paramsType ,int returnType)
    {
        MethodSymbolsTable.Ident temp = null;
        for(MethodSymbolsTable.Ident id : this.table)
            if (id.tok.getText().equals(name) && id.numberParams == amountParams && id.returnType == returnType && id.paramsType == paramsType) {
                temp = id;
                break;
            }
        return temp;
    }

    public void print() {
        System.out.println("****** SYMBOLS TABLE STATE ******");
        if (!this.table.isEmpty()) {
            for (MethodSymbolsTable.Ident i : this.table) {
                String nivel = "";
                for (int j = 0; j < i.level; j++) {
                    nivel += "\t";
                }
                System.out.println(nivel + "Name: " + i.tok.getText() + ", "
                                         + "Number of parameters: " + i.numberParams + ", "
                                         + "Parameters type: " + i.paramsType.toString() + ", "
                                         + "Return type: " + i.returnType + ", "
                                         + "Level: " + i.level);
            }
            System.out.println("------------------------------------------");
        }
        else
            System.out.println("Empty table");
    }

    public LinkedList<MethodSymbolsTable.Ident> getTable() {
        return this.table;
    }

}
