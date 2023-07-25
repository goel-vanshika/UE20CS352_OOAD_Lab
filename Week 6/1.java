import java.util.*;

class Test
{
    static int Preced(char ch)
    {
        switch(ch)
        {
            case '+': 
                return 1;
            case '-':
                return 1;
            
            case '/':
                return 2;
            case '*':
                return 2;
            
            case '^':
                return 3;
        }
        return -1;
    }

    static String InfixtoPost(String infix)
    {
        char charac;
        String postfix = "";
        Deque<Character> stack = new ArrayDeque<Character>();
        for(int i=0;i<infix.length();i++)
        {
            charac = infix.charAt(i);
            if(Character.isLetterOrDigit(charac))
            {
                postfix = postfix + charac;
            }
            else if(charac=='(')
            {
                stack.push(charac);
            }
            else if(charac==')')
            {
                while(!stack.isEmpty() && stack.peek() != '(')
                {
                    postfix = postfix + stack.peek();
                    stack.pop();
                }
                stack.pop();s
            }
            else
            {
                while(!stack.isEmpty() && Preced(charac) <= Preced(stack.peek()))
                {
                    postfix = postfix + stack.peek();
                    stack.pop();
                }
                stack.push(charac);
            }
        }  
        while(!stack.isEmpty())
        {
            if(stack.peek()=='(')
                return "Invalid";                    
                postfix = postfix + stack.peek();
                stack.pop();
        }
        return postfix;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for(int i=0;i<N;i++)
        {
            String inputline = sc.nextLine();
            System.out.println(InfixtoPost(inputline));
        }
    }
}
