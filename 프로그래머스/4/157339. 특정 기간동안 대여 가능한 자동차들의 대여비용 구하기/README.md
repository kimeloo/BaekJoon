# [level 4] 특정 기간동안 대여 가능한 자동차들의 대여비용 구하기 - 157339 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/157339) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > JOIN

### 채점결과

Empty

### 제출 일자

2026년 01월 01일 14:55:57

### 문제 설명

<p style="user-select: auto !important;">다음은 어느 자동차 대여 회사에서 대여 중인 자동차들의 정보를 담은 <code style="user-select: auto !important;">CAR_RENTAL_COMPANY_CAR</code> 테이블과 자동차 대여 기록 정보를 담은 <code style="user-select: auto !important;">CAR_RENTAL_COMPANY_RENTAL_HISTORY</code> 테이블과 자동차 종류 별 대여 기간 종류 별 할인 정책 정보를 담은 <code style="user-select: auto !important;">CAR_RENTAL_COMPANY_DISCOUNT_PLAN</code> 테이블 입니다.</p>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">CAR_RENTAL_COMPANY_CAR</code> 테이블은 아래와 같은 구조로 되어있으며, <code style="user-select: auto !important;">CAR_ID</code>, <code style="user-select: auto !important;">CAR_TYPE</code>, <code style="user-select: auto !important;">DAILY_FEE</code>, <code style="user-select: auto !important;">OPTIONS</code> 는 각각 자동차 ID, 자동차 종류, 일일 대여 요금(원), 자동차 옵션 리스트를 나타냅니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">CAR_ID</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">CAR_TYPE</td>
<td style="user-select: auto !important;">VARCHAR(255)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DAILY_FEE</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">OPTIONS</td>
<td style="user-select: auto !important;">VARCHAR(255)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">자동차 종류는 '세단', 'SUV', '승합차', '트럭', '리무진' 이 있습니다. 자동차 옵션 리스트는 콤마(',')로 구분된 키워드 리스트(예: ''열선시트,스마트키,주차감지센서'')로 되어있으며, 키워드 종류는 '주차감지센서', '스마트키', '네비게이션', '통풍시트', '열선시트', '후방카메라', '가죽시트' 가 있습니다.</p>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">CAR_RENTAL_COMPANY_RENTAL_HISTORY</code> 테이블은 아래와 같은 구조로 되어있으며, <code style="user-select: auto !important;">HISTORY_ID</code>, <code style="user-select: auto !important;">CAR_ID</code>, <code style="user-select: auto !important;">START_DATE</code>, <code style="user-select: auto !important;">END_DATE</code> 는 각각 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일을 나타냅니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">HISTORY_ID</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">CAR_ID</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">START_DATE</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">END_DATE</td>
<td style="user-select: auto !important;">DATE</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">CAR_RENTAL_COMPANY_DISCOUNT_PLAN</code> 테이블은 아래와 같은 구조로 되어있으며, <code style="user-select: auto !important;">PLAN_ID</code>, <code style="user-select: auto !important;">CAR_TYPE</code>, <code style="user-select: auto !important;">DURATION_TYPE</code>, <code style="user-select: auto !important;">DISCOUNT_RATE</code> 는 각각 요금 할인 정책 ID, 자동차 종류, 대여 기간 종류, 할인율(%)을 나타냅니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">Column name</th>
<th style="user-select: auto !important;">Type</th>
<th style="user-select: auto !important;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">PLAN_ID</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">CAR_TYPE</td>
<td style="user-select: auto !important;">VARCHAR(255)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DURATION_TYPE</td>
<td style="user-select: auto !important;">VARCHAR(255)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">DISCOUNT_RATE</td>
<td style="user-select: auto !important;">INTEGER</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">할인율이 적용되는 대여 기간 종류로는 '7일 이상' (대여 기간이 7일 이상 30일 미만인 경우), '30일 이상' (대여 기간이 30일 이상 90일 미만인 경우), '90일 이상' (대여 기간이 90일 이상인 경우) 이 있습니다. 대여 기간이 7일 미만인 경우 할인정책이 없습니다.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">문제</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">CAR_RENTAL_COMPANY_CAR</code> 테이블과 <code style="user-select: auto !important;">CAR_RENTAL_COMPANY_RENTAL_HISTORY</code> 테이블과 <code style="user-select: auto !important;">CAR_RENTAL_COMPANY_DISCOUNT_PLAN</code> 테이블에서 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서 자동차 ID, 자동차 종류, 대여 금액(컬럼명: <code style="user-select: auto !important;">FEE</code>) 리스트를 출력하는 SQL문을 작성해주세요. 결과는 대여 금액을 기준으로 내림차순 정렬하고, 대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬, 자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬해주세요.</p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;">예를 들어 <code style="user-select: auto !important;">CAR_RENTAL_COMPANY_CAR</code> 테이블과 <code style="user-select: auto !important;">CAR_RENTAL_COMPANY_RENTAL_HISTORY</code> 테이블과 <code style="user-select: auto !important;">CAR_RENTAL_COMPANY_DISCOUNT_PLAN</code> 테이블이 다음과 같다면</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">CAR_ID</th>
<th style="user-select: auto !important;">CAR_TYPE</th>
<th style="user-select: auto !important;">DAILY_FEE</th>
<th style="user-select: auto !important;">OPTIONS</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">SUV</td>
<td style="user-select: auto !important;">25000</td>
<td style="user-select: auto !important;">가죽시트,열선시트,후방카메라</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">세단</td>
<td style="user-select: auto !important;">14000</td>
<td style="user-select: auto !important;">스마트키,네비게이션,열선시트</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">트럭</td>
<td style="user-select: auto !important;">32000</td>
<td style="user-select: auto !important;">주차감지센서,후방카메라,가죽시트</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">세단</td>
<td style="user-select: auto !important;">12000</td>
<td style="user-select: auto !important;">열선시트,후방카메라</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">세단</td>
<td style="user-select: auto !important;">22000</td>
<td style="user-select: auto !important;">스마트키,주차감지센서</td>
</tr>
</tbody>
      </table><table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">HISTORY_ID</th>
<th style="user-select: auto !important;">CAR_ID</th>
<th style="user-select: auto !important;">START_DATE</th>
<th style="user-select: auto !important;">END_DATE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-08-27</td>
<td style="user-select: auto !important;">2022-09-02</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">2022-10-03</td>
<td style="user-select: auto !important;">2022-10-04</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2022-10-05</td>
<td style="user-select: auto !important;">2022-10-20</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">2022-10-10</td>
<td style="user-select: auto !important;">2022-11-12</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">2022-10-16</td>
<td style="user-select: auto !important;">2022-10-17</td>
</tr>
</tbody>
      </table><table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">PLAN_ID</th>
<th style="user-select: auto !important;">CAR_TYPE</th>
<th style="user-select: auto !important;">DURATION_TYPE</th>
<th style="user-select: auto !important;">DISCOUNT_RATE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">트럭</td>
<td style="user-select: auto !important;">7일 이상</td>
<td style="user-select: auto !important;">5%</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">2</td>
<td style="user-select: auto !important;">트럭</td>
<td style="user-select: auto !important;">30일 이상</td>
<td style="user-select: auto !important;">7%</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">3</td>
<td style="user-select: auto !important;">트럭</td>
<td style="user-select: auto !important;">90일 이상</td>
<td style="user-select: auto !important;">10%</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">4</td>
<td style="user-select: auto !important;">세단</td>
<td style="user-select: auto !important;">7일 이상</td>
<td style="user-select: auto !important;">5%</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">세단</td>
<td style="user-select: auto !important;">30일 이상</td>
<td style="user-select: auto !important;">10%</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">6</td>
<td style="user-select: auto !important;">세단</td>
<td style="user-select: auto !important;">90일 이상</td>
<td style="user-select: auto !important;">15%</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">7</td>
<td style="user-select: auto !important;">SUV</td>
<td style="user-select: auto !important;">7일 이상</td>
<td style="user-select: auto !important;">3%</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">8</td>
<td style="user-select: auto !important;">SUV</td>
<td style="user-select: auto !important;">30일 이상</td>
<td style="user-select: auto !important;">8%</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">9</td>
<td style="user-select: auto !important;">SUV</td>
<td style="user-select: auto !important;">90일 이상</td>
<td style="user-select: auto !important;">12%</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 2022년 11월 1일 부터 2022년 11월 30일까지 대여가능한 자동차는 자동차 ID가 1, 4, 5인 자동차입니다.</p>

<p style="user-select: auto !important;">일일 대여 요금에 자동차 종류 별 대여기간이 30일 이상인 경우의 할인율을 적용하여 30일간의 대여 금액을 구하면,</p>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">자동차 ID가 1인 경우, 일일 대여 금액 25,000원에서 8% 할인율을 적용하고 30일을 곱하면 총 대여 금액은 690,000원</li>
<li style="user-select: auto !important;">자동차 ID가 4인 경우, 일일 대여 금액 12,000원에서 10% 할인율을 적용하고 30일을 곱하면 총 대여 금액은 324,000원</li>
<li style="user-select: auto !important;">자동차 ID가 5인 경우, 일일 대여 금액 22,000원에서 10% 할인율을 적용하고 30일을 곱하면 총 대여 금액은 621,000원이고, 대여 금액이 50만원 이상 200만원 미만인 경우에 대해서 대여 금액을 기준으로 내림차순, 자동차 종류를 기준으로 오름차순 및 자동차 ID를 기준으로 내림차순 정렬하면 다음과 같아야 합니다.</li>
</ul>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">CAR_ID</th>
<th style="user-select: auto !important;">CAR_TYPE</th>
<th style="user-select: auto !important;">FEE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">5</td>
<td style="user-select: auto !important;">세단</td>
<td style="user-select: auto !important;">690000</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">1</td>
<td style="user-select: auto !important;">SUV</td>
<td style="user-select: auto !important;">621000</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">주의사항</h5>

<p style="user-select: auto !important;"><code style="user-select: auto !important;">FEE</code>의 경우 예시처럼 정수부분만 출력되어야 합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges