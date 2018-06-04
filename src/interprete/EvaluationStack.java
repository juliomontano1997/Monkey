package interprete;
        import java.util.EmptyStackException;
        import java.util.Stack;

public class EvaluationStack {
    private Stack<Object> evalStack;

    public EvaluationStack(){
        this.evalStack= new Stack<Object>();
    }

    public void pushValue(Object elem){
        this.evalStack.push(elem);
    }

    public Object popValue(){
        try
        {
            return this.evalStack.pop();
        }
        catch (EmptyStackException e)
        {
            return null;
        }

    }

    public void  print(String men)
    {
        System.out.println("\nEvaluation stack state:");
        for (Object elemet:evalStack.toArray()) {
            System.out.println(elemet);
        }
    }
}
