package src.programmers.stackqueue.printer;

import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Location> queue = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Location(i, priorities[i]));
        }

        while (!queue.isEmpty()) {
            int peekValue = queue.peek().value;

            boolean check = false;

            for (Location forCheck : queue) {
                if (forCheck.value > peekValue) {
                    check = true;
                    break;
                }
            }

            if (check) {
                queue.add(queue.poll()); // poll = dequeue 와 동일, queue의 마지막에 add 진행
            } else { // 정렬 마무리 된 시점
                answer++;

                if (queue.poll().location == location) {
                    return answer;
                }
            }
        }
        return answer;
    }


    class Location {
        int location;

        int value;

        public Location(int location, int value) {
            this.location = location;
            this.value = value;
        }
    }
}