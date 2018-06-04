import generated.*;
import checker.Checker;
import interprete.Interprete;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;


public class Main {

    public static void main(String[] args){
        ownScanner inst = null;
        ownParser parser = null;

        ANTLRInputStream input=null;
        CommonTokenStream tokens = null;
        try {
            input = new ANTLRInputStream(new FileReader("test.txt"));
            inst = new ownScanner(input);
            tokens = new CommonTokenStream(inst);
            parser = new ownParser(tokens);
        }
        catch(Exception e){System.out.println("No hay archivo");}

        try {
            ParseTree tree = parser.program();
            System.out.println("\n+++++++++++++++++++++++++++++++  Checker messajes++++++++++++++++++++++++++++++++\n");
            Checker che = new Checker();
            che.visit(tree);
            System.out.println("\n+++++++++++++++++++++++++++++++ Interprete messajes +++++++++++++++++++++++++++++\n");
            Interprete interprete = new Interprete();
            interprete.visit(tree);

            interprete.dataStorage.print();
            interprete.evaluationStack.print("");

            //java.util.concurrent.Future <JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(tree,parser);
            //treeGUI.get().setVisible(true);
            System.out.println("Compilación Exitosa!!\n");
        } catch(RecognitionException e) {
            System.out.println("Compilación Fallida!!");
        }

    }
}
