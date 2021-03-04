package com.fanns.leetcode.editor.cn;
//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。 
//
// 实现 MyStack 类： 
//
// 
// void push(int x) 将元素 x 压入栈顶。 
// int pop() 移除并返回栈顶元素。 
// int top() 返回栈顶元素。 
// boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 注意： 
//
// 
// 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。 
// 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 2, 2, false]
//
//解释：
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // 返回 2
//myStack.pop(); // 返回 2
//myStack.empty(); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用100 次 push、pop、top 和 empty 
// 每次调用 pop 和 top 都保证栈不为空 
// 
//
// 
//
// 进阶：你能否实现每种操作的均摊时间复杂度为 O(1) 的栈？换句话说，执行 n 个操作的总时间复杂度 O(n) ，尽管其中某个操作可能需要比其他操作更长的
//时间。你可以使用两个以上的队列。 
// Related Topics 栈 设计 
// 👍 285 👎 0

import java.util.LinkedList;
import java.util.Queue;

public class P225ImplementStackUsingQueues{
    public static void main(String[] args) {
        MyStack solution = new P225ImplementStackUsingQueues().new MyStack();
        solution.push(1);
        solution.push(2);
        System.out.println(solution.top());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {

        private Queue<Integer> queue1;
        private Queue<Integer> queue2;
        private boolean using1 = true;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (using1) {
                queue1.offer(x);
            } else {
                queue2.offer(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int last = 0;
            if (using1) {
                while (!queue1.isEmpty()) {
                    boolean lastOne = queue1.size() == 1 ? true : false;
                    last = queue1.poll();
                    if (!lastOne) {
                        queue2.offer(last);
                    }
                }
                using1 = false;
            } else {
                while (!queue2.isEmpty()) {
                    boolean lastOne = queue2.size() == 1 ? true : false;
                    last = queue2.poll();
                    if (!lastOne) {
                        queue1.offer(last);
                    }
                }
                using1 = true;
            }
            return last;
        }

        /** Get the top element. */
        public int top() {
            int last = 0;
            if (using1) {
                while (!queue1.isEmpty()) {
                    last = queue1.poll();
                    queue2.offer(last);
                }
                using1 = false;
            } else {
                while (!queue2.isEmpty()) {
                    last = queue2.poll();
                    queue1.offer(last);
                }
                using1 = true;
            }
            return last;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return using1 ? queue1.isEmpty() : queue2.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}