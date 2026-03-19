package com.leetcode.graphtheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/// [力扣题解](https://leetcode.cn/problems/course-schedule/?envType=study-plan-v2&envId=top-100-liked)
public class LeetCode207 {
    /**
     * BFS 解法
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 用数组来表示每一门课的先修课程的数量（有向图中的入度）
        int[] preStudy = new int[numCourses];
        // 用一个集合来记录课之间的先修关系
        List<List<Integer>> relation = new ArrayList<>();
        // 初始化relation ,因为课程出现的时机不是按顺序的
        for (int i = 0; i < numCourses; i++) {
            relation.add(new ArrayList<>());
        }

        // 填充集合关系
        for (int[] prerequisite : prerequisites) {
            int curCourse = prerequisite[0];
            preStudy[curCourse]++; // 入度加1
            int preCourse = prerequisite[1];
            // 关系为：当前课程是哪些课程的先修，到时候修完课程就将对应课程的入度减1
            relation.get(preCourse).add(curCourse);
        }

        Queue<Integer> studyNow = new LinkedList<>();
        int ready = 0;
        // 先添加入度为0的课程，因为入度为0的课程没有先修课程
        for (int i = 0; i < numCourses; i++) {
            if (preStudy[i] == 0) {
                studyNow.add(i);
            }
        }
        while (!studyNow.isEmpty()) {
            int course = studyNow.remove();
            ready++;
            for (int preCourse : relation.get(course)) {
                // 减去当前课程的先修课程数量，如果减到0，则加入队列
                if (--preStudy[preCourse] == 0) {
                    studyNow.add(preCourse);
                }
            }
        }
        return ready == numCourses;
    }
}
