# STACK

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/38552da6-340d-42c1-a9a1-b181ff331f03/0a924e39-482b-4acb-a5ca-d88e6d92c252/Untitled.png)

스택이란 젠가 통에서 젠가 블럭을 뺄때 처럼 입구와 출구가 같은 자료구조를 스택(stack)이라고 한다.

이러한 구조를 후입선출 구조(LIFO : Last In First Out)라고 한다.

Stack에는 5가지 함수가 사용된다.

1. push(x) : x 를 스택에 넣는다.
2. size() : 스택에 쌓인 블럭의 개수를 반환한다.
3. empty() : 비어있다면 true, 비어있지 않다면 false를 반환한다.
4. top() : stack에 블럭을 제거하지 않고 최상단의 값을 반환한다.
5. pop() : 맨 위에 숫자를 반환한다( 최상단의 값이 제거된다)

stack 과 배열의 관계

배열의 크기가 무한하다고 가정했을떄, 배열에 삽입과 삭제 연산이 발생하는 장소를 맨 뒤에만 생긴다는 가정했을때, 배열을 스택처럼 활용할 수 있다.

스택을 응용하는 아주 유명한 문제는 괄호 짝 맞추는 문제가 있다.

소괄호 로 주어진 문장이 있을때, 해당 문장의 괄호가 올바른 괄호 문자열인지 아닌지 판별하는 문제가 있다.

예를 들어 `(())((()()))` 같은 문자열은 올바른 괄호 문자열이며, `())(`는 올바르지 않은 괄호 문자열 이다.

문제 풀이 방법으로는
여는 괄호가 오면 스택에 넣고 닫는 괄호가 오면 스택에 있는 여는 괄호를 제거 한다.

모든 문자열을 이러한 과정을 거쳤을때, 스택에 괄호가 남아있다면 올바르지 않는 괄호 문자열이고 스택이 비어있다면 올바른 괄호 문자열이다.

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if(check(s)) System.out.println("Yes");
        else System.out.println("No");
        
    }

    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>(); 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                stack.push('(');
            }
            else {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                else
                    return false;
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
```

# QUEUE

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/38552da6-340d-42c1-a9a1-b181ff331f03/35d0c39a-c860-4fe3-8f20-211d3670f5f8/Untitled.png)

놀이공원에서 놀이기구를 기다리고 있는것을 생각해보자. 먼저 온사람이 먼저 놀이기구를 탈 수 있다. 이러한 구조를 선입선출(FIFO : First In First Out) 이라고 한다. Queue는 선입선출 구조로 되어있다.

queue에는 5가지 함수가 사용 된다.

1. push(x) : x를 queue의 맨 뒤에 추가한다.
2. size() : queue 안에 들어있는 데이터의 개수를 반환
3. empty() : queue에 남아있는 데이터가 없다면 ture, 있으면 false를 반환
4. front() : queue에 맨 앞에 있는 숫자를 반환, 데이터가 삭제 되지는 않음
5. pop() : queue의 맨 앞에 있는 숫자 값을 반환, 동시에 queue에서 반환된 데이터 삭제

배열과 큐의 관계

큐는 배열과는 다르게 배열에서 맨 앞에 있는 값을 제거하려면 O(N)만큼의 시간이 소요된다.

따라서 배열을 큐처럼 활용하는 것은 적합하지 않다. 다만 연결 리스트를 사용하면 Queue처럼 모든 연산자에 O(1)만큼 시간소요를 만들 수 이다.

자바에서 큐의 사용

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
            else if(s.equals("pop")) {
                System.out.println(queue.poll());
            }
            else if(s.equals("size")) {
                System.out.println(queue.size());
            }
            else if(s.equals("empty")) {
            if(queue.isEmpty()) System.out.println(1);
            else System.out.println(0);
            }
            else {
                System.out.println(queue.peek());
            }

        }
    }
}
```

# Deque

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/38552da6-340d-42c1-a9a1-b181ff331f03/92f277e7-4245-46f0-8268-98121261a34b/Untitled.png)

스택 + 큐가 합쳐진 자료구조 즉 맨 앞,뒤 삽입/삭제가 모두 가능하다는 장점이 있다.

앞 뒤 모두 push/ pop이 가능하기 때문에, 메서드 이름을

앞부분 삽입 삭제 → push front, pop front

뒷부분 삽입 삭제 → push back, pop back

자바에서 deque 사용

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push_front")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }
            else if(s.equals("push_back")) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            else if(s.equals("pop_front")) {
                System.out.println(deque.pollFirst());
            }
            else if(s.equals("pop_back")) {
                System.out.println(deque.pollLast());
            }
            else if(s.equals("empty")) {
                if(deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(s.equals("size")) {
                System.out.println(deque.size());
            }
            else if(s.equals("front")) {
                System.out.println(deque.peekFirst());
            }
            else {
                System.out.println(deque.peekLast());
            }

        }
    }
}
```