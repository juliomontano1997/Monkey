import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import checker.Checker;
import checker.CheckerErrors;
import generated.ParserErrors;
import generated.ownParser;
import generated.ownScanner;
import interprete.Interprete;
import interprete.InterpreteErrors;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author julio
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    private File currentEditingFile;
    private ownScanner scanner;
    private ownParser parser;
    private Checker checker;
    private ParseTree tree;
    private Interprete interprete;
    private ParserErrors parserErrors;
    private java.util.concurrent.Future <JFrame> treeGUI = null;
    private org.antlr.v4.runtime.ANTLRInputStream input=null;
    private CommonTokenStream tokens = null;

    public Interfaz() {
        initComponents();
    }
    public Interfaz(File file)
    {
        initComponents();
        currentEditingFile = file;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        openDialog.setFileFilter(filter);
        readTheParamFile(file);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        saveNewDialog = new javax.swing.JFileChooser();
        openDialog = new javax.swing.JFileChooser();
        codeContainer = new javax.swing.JScrollPane();
        codeArea = new javax.swing.JTextArea();
        openButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        runCommandButton = new javax.swing.JButton();
        showtreeButton = new javax.swing.JButton();
        codePosition = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messagePanel = new javax.swing.JTextArea();
        commandEntry = new javax.swing.JTextField();
        runButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Monkey");
        setLocation(new java.awt.Point(0, 0));

        codeArea.setColumns(20);
        codeArea.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        codeArea.setRows(5);
        codeArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                JTextArea editArea = (JTextArea)e.getSource();
                int linea = 1;
                int columna = 1;

                try
                {
                    int caretpos = editArea.getCaretPosition();
                    linea= editArea.getLineOfOffset(caretpos);
                    columna = caretpos - editArea.getLineStartOffset(linea);
                    linea += 1;
                }
                catch (Exception error)
                {

                }
                actualizarPosicionCursor(linea, columna);
            }});
        codeContainer.setViewportView(codeArea);

        //Dialogs
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        openDialog.setFileFilter(filter);
        saveNewDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        saveNewDialog.setDialogTitle("Selecciona el directorio");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Monkey");



        openButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open.png"))); // NOI18N
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        runCommandButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/run.png"))); // NOI18N
        runCommandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runCommandButtonActionPerformed(evt);
            }
        });

        showtreeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arbol.png"))); // NOI18N
        showtreeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showtreeButtonActionPerformed(evt);
            }
        });

        messagePanel.setColumns(20);
        messagePanel.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        messagePanel.setRows(5);
        jScrollPane2.setViewportView(messagePanel);

        commandEntry.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N

        runButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/run.png"))); // NOI18N
        runButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel1.setText("Enter command:");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel2.setText("Output");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(codeContainer))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(openButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(saveButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(runButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(showtreeButton)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(commandEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(runCommandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(codePosition, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(saveButton)
                                        .addComponent(openButton)
                                        .addComponent(showtreeButton)
                                        .addComponent(runButton1))
                                .addGap(18, 18, 18)
                                .addComponent(codeContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(commandEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(runCommandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(codePosition, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //Show File Open dialogue here
        int status = openDialog.showOpenDialog(rootPane);
        if (status == JFileChooser.APPROVE_OPTION)
        {
            if (currentEditingFile != null)
            {
                // A file is opened and is being edited. Open the new file in new window
                Interfaz newWindow = new Interfaz(openDialog.getSelectedFile());
                newWindow.setVisible(true);
                newWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                newWindow.pack();
                return;
            }

            currentEditingFile = openDialog.getSelectedFile();
            try
            {
                // Read the content of file
                Scanner scn = new Scanner(new FileInputStream(currentEditingFile));
                String buffer = "";
                while (scn.hasNext()) {
                    buffer += scn.nextLine() + "\n";
                }
                codeArea.setText(buffer);
            }
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            System.out.println("No file selected");
        }
    }

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        saveArchive();
    }



    private void runButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try
        {
            saveArchive();
            this.messagePanel.setText("");
            this.messagePanel.setForeground(Color.BLUE);
            parserErrors = new ParserErrors();
            input = new org.antlr.v4.runtime.ANTLRInputStream( new FileInputStream(currentEditingFile));
            scanner = new ownScanner(input);
            scanner.removeErrorListeners();
            scanner.addErrorListener(parserErrors);
            tokens = new CommonTokenStream(scanner);

            parser = new ownParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(parserErrors);

            tree = parser.program();
            checker = new Checker();
            checker.visit(tree);

            interprete = new Interprete();
            interprete.visit(tree);

            this.messagePanel.setText(this.messagePanel.getText()+interprete.logs+"\n>> Fin del programa");
            interprete.logs = "";

        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(rootPane, "An error has occurred", "Can't save", JOptionPane.ERROR_MESSAGE);
        }
        catch(ParseCancellationException e)
        {
            this.printError(e.getMessage());
        }
        catch (InterpreteErrors e)
        {
            this.printError(e.getMessage());
        }
        catch (CheckerErrors e)
        {
            this.printError(e.getMessage());
        }
        catch (StackOverflowError e)
        {
            this.printError(interprete.logs+"Error: Stack over flow");
        }
        catch(NullPointerException e)
        {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(rootPane, "\n" + "Select the code to compile", "Warning", JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void showtreeButtonActionPerformed(java.awt.event.ActionEvent evt) {
       if(!Objects.equals(tree, null))
        {
            treeGUI = org.antlr.v4.gui.Trees.inspect(tree,parser);
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "\n" +
                    "The tree can not be displayed, you must compile the program first", "\n" +
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }


    private void  actualizarPosicionCursor(int linea,int columna)
    {
        codePosition.setText("Row: " + linea + " Col: " + columna);
    }

    public void readTheParamFile(File file) {
        try {
            Scanner scn = new Scanner(file);
            String buffer = "";
            while (scn.hasNext()) {
                buffer += scn.nextLine() + "\n";
            }
            codeArea.setText(buffer);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void runCommandButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        this.messagePanel.setForeground(Color.BLUE);
        try
        {
            if(this.scanner!=null)
            {
                input= new org.antlr.v4.runtime.ANTLRInputStream(commandEntry.getText());
                parserErrors = new ParserErrors();
                scanner = new ownScanner(input);
                scanner.removeErrorListeners();
                scanner.addErrorListener(parserErrors);
                tokens = new CommonTokenStream(scanner);

                parser = new ownParser(tokens);
                parser.removeErrorListeners();
                parser.addErrorListener(parserErrors);
                ParseTree consoleTree = parser.program();
                checker.visit(consoleTree);
                interprete.visit(consoleTree);

                String data =interprete.logs;
                Object printElement = interprete.evaluationStack.popValue();
                if(printElement!=null)
                {
                    data +=printElement.toString();
                }
                this.messagePanel.setText(data+"\n> Fin del programa");
                interprete.logs = "";
            }
            else
            {
                org.antlr.v4.runtime.ANTLRInputStream input= new org.antlr.v4.runtime.ANTLRInputStream(commandEntry.getText());
                ownScanner consoleScanner = new ownScanner(input);
                consoleScanner.removeErrorListeners();
                consoleScanner.addErrorListener(new ParserErrors());
                CommonTokenStream consoleTokens  = new CommonTokenStream(consoleScanner);

                ownParser consoleParser = new ownParser(consoleTokens);
                consoleParser.addErrorListener(new ParserErrors());
                ParseTree consoleTree =  consoleParser.program();

                Checker consoleChecker = new Checker();
                consoleChecker.visit(consoleTree);

                Interprete consoleInterprete = new Interprete();
                consoleInterprete.visit(consoleTree);
                String data =consoleInterprete.logs;
                Object printElement = consoleInterprete.evaluationStack.popValue();
                if(printElement!=null)
                {
                    data +=printElement.toString();
                }
                this.messagePanel.setText(data+"\n> Fin del programa");
                consoleInterprete.logs = "";
            }
        }
        catch(ParseCancellationException e)
        {
            this.printError(e.getMessage());
        }
        catch (InterpreteErrors e)
        {
            this.printError(e.getMessage());
        }
        catch (CheckerErrors e)
        {
            this.printError(e.getMessage());
        }
        catch (StackOverflowError e)
        {
            this.printError(interprete.logs+"Error: Stack over flow");
        }
    }

    private void printError(String errorMessage)
    {
        String errs  = this.messagePanel.getText();
        this.messagePanel.setText(errs+"\n"+errorMessage);
        this.messagePanel.requestFocus();
        this.messagePanel.setForeground(Color.RED);
        interprete.dataStorage.print();
        interprete.evaluationStack.print("");
    }
    private void saveArchive()
    {
        //If we are editing a file opened, then we have to save the contents on the same file, currentEditingFile
        if (currentEditingFile != null) {
            try {
                PrintWriter printWriter = new PrintWriter(currentEditingFile);
                printWriter.write(codeArea.getText());
                printWriter.close();
                //JOptionPane.showMessageDialog(rootPane, "Saved to " + currentEditingFile.getName(), "Done", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            int status = saveNewDialog.showOpenDialog(rootPane);
            if (status == JFileChooser.APPROVE_OPTION)
            {
                //We got directory. Now needs file name
                String fileName = JOptionPane.showInputDialog("File Name", "Untitled.txt");
                if (!fileName.contains(".txt"))
                {
                    fileName += ".txt";
                }
                File f = new File(saveNewDialog.getSelectedFile() + "\\" + fileName);
                if (f.exists())
                {
                    JOptionPane.showMessageDialog(rootPane, "File Already Exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    try
                    {
                        f = new File(saveNewDialog.getSelectedFile().getParent()+ "\\" + fileName);
                        PrintWriter printWriter = new PrintWriter(f);
                        printWriter.write(codeArea.getText());
                        printWriter.close();
                        //JOptionPane.showMessageDialog(rootPane, "Saved", "Done", JOptionPane.INFORMATION_MESSAGE);
                        currentEditingFile = f;
                    }
                    catch (IOException ex)
                    {
                        Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Error Occured", "Cant Save", JOptionPane.ERROR_MESSAGE);
            }
        }
    }






    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    private javax.swing.JTextArea codeArea;
    private javax.swing.JScrollPane codeContainer;
    private javax.swing.JLabel codePosition;
    private javax.swing.JTextField commandEntry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messagePanel;
    private javax.swing.JButton openButton;
    private javax.swing.JFileChooser openDialog;
    private javax.swing.JButton runButton1;
    private javax.swing.JButton runCommandButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JFileChooser saveNewDialog;
    private javax.swing.JButton showtreeButton;
}
