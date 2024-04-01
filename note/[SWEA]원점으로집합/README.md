# [D4] 원점으로 집합 - 8458 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWzaq5KKk_ADFAVU) 

### 풀이 방법

핵심
: 모든 점이 원점으로 모일 수 있는지 여부 판단
: 반드시 한 번의 움직임에 모든 점은 i만큼 이동해야 한다. 

> 이동횟수의 차이가 짝수여야 모든 점이 원점으로 도달 가능

고려할 것
- i번 움직였을 때의 이동 거리
- 원점과의 거리가 가장 먼 점의 이동 거리
- 다른 점들의 이동거리

각 이동거리 간 차이가 짝수여야 한다 -> 모두 홀수 || 모두 짝수

