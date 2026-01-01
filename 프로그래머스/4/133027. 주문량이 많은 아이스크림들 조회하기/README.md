# [level 4] 주문량이 많은 아이스크림들 조회하기 - 133027 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/133027) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > JOIN

### 채점결과

Empty

### 제출 일자

2026년 01월 01일 12:24:36

### 문제 설명

<p style="user-select: auto !important;">다음은 아이스크림 가게의 상반기 주문 정보를 담은 <code style="user-select: auto !important;">FIRST_HALF</code> 테이블과 7월의 아이스크림 주문 정보를 담은 <code style="user-select: auto !important;">JULY</code> 테이블입니다. <code style="user-select: auto !important;">FIRST_HALF</code> 테이블 구조는 다음과 같으며, <code style="user-select: auto !important;">SHIPMENT_ID</code>, <code style="user-select: auto !important;">FLAVOR</code>, <code style="user-select: auto !important;">TOTAL_ORDER</code>는 각각 아이스크림 공장에서 아이스크림 가게까지의 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량을 나타냅니다. <code style="user-select: auto !important;">FIRST_HALF</code> 테이블의 기본 키는 <code style="user-select: auto !important;">FLAVOR</code>입니다. <code style="user-select: auto !important;">FIRST_HALF</code>테이블의 <code style="user-select: auto !important;">SHIPMENT_ID</code>는 <code style="user-select: auto !important;">JULY</code>테이블의 <code style="user-select: auto !important;">SHIPMENT_ID</code>의 외래 키입니다. </p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="text-align: left; user-select: auto !important;">NAME</th>
<th style="text-align: left; user-select: auto !important;">TYPE</th>
<th style="user-select: auto !important;">NULLABLE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">SHIPMENT_ID</td>
<td style="text-align: left; user-select: auto !important;">INT(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">FLAVOR</td>
<td style="text-align: left; user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">TOTAL_ORDER</td>
<td style="text-align: left; user-select: auto !important;">INT(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">JULY</code> 테이블 구조는 다음과 같으며, <code style="user-select: auto !important;">SHIPMENT_ID</code>, <code style="user-select: auto !important;">FLAVOR</code>, <code style="user-select: auto !important;">TOTAL_ORDER</code> 은 각각 아이스크림 공장에서 아이스크림 가게까지의 출하 번호, 아이스크림 맛, 7월 아이스크림 총주문량을 나타냅니다.  <code style="user-select: auto !important;">JULY</code> 테이블의 기본 키는 <code style="user-select: auto !important;">SHIPMENT_ID</code>입니다. <code style="user-select: auto !important;">JULY</code>테이블의 <code style="user-select: auto !important;">FLAVOR</code>는 <code style="user-select: auto !important;">FIRST_HALF</code> 테이블의  <code style="user-select: auto !important;">FLAVOR</code>의 외래 키입니다. 7월에는 아이스크림 주문량이 많아 같은 아이스크림에 대하여 서로 다른 두 공장에서 아이스크림 가게로 출하를 진행하는 경우가 있습니다. 이 경우 같은 맛의 아이스크림이라도 다른 출하 번호를 갖게 됩니다.</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="text-align: left; user-select: auto !important;">NAME</th>
<th style="text-align: left; user-select: auto !important;">TYPE</th>
<th style="user-select: auto !important;">NULLABLE</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">SHIPMENT_ID</td>
<td style="text-align: left; user-select: auto !important;">INT(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">FLAVOR</td>
<td style="text-align: left; user-select: auto !important;">VARCHAR(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">TOTAL_ORDER</td>
<td style="text-align: left; user-select: auto !important;">INT(N)</td>
<td style="user-select: auto !important;">FALSE</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">문제</h5>

<p style="user-select: auto !important;">7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요. </p>

<hr style="user-select: auto !important;">

<h5 style="user-select: auto !important;">예시</h5>

<p style="user-select: auto !important;">예를 들어 <code style="user-select: auto !important;">FIRST_HALF</code> 테이블이 다음과 같고</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="text-align: left; user-select: auto !important;">SHIPMENT_ID</th>
<th style="text-align: left; user-select: auto !important;">FLAVOR</th>
<th style="user-select: auto !important;">TOTAL_ORDER</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">101</td>
<td style="text-align: left; user-select: auto !important;">chocolate</td>
<td style="user-select: auto !important;">3200</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">102</td>
<td style="text-align: left; user-select: auto !important;">vanilla</td>
<td style="user-select: auto !important;">2800</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">103</td>
<td style="text-align: left; user-select: auto !important;">mint_chocolate</td>
<td style="user-select: auto !important;">1700</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">104</td>
<td style="text-align: left; user-select: auto !important;">caramel</td>
<td style="user-select: auto !important;">2600</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">105</td>
<td style="text-align: left; user-select: auto !important;">white_chocolate</td>
<td style="user-select: auto !important;">3100</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">106</td>
<td style="text-align: left; user-select: auto !important;">peach</td>
<td style="user-select: auto !important;">2450</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">107</td>
<td style="text-align: left; user-select: auto !important;">watermelon</td>
<td style="user-select: auto !important;">2150</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">108</td>
<td style="text-align: left; user-select: auto !important;">mango</td>
<td style="user-select: auto !important;">2900</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">109</td>
<td style="text-align: left; user-select: auto !important;">strawberry</td>
<td style="user-select: auto !important;">3100</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">110</td>
<td style="text-align: left; user-select: auto !important;">melon</td>
<td style="user-select: auto !important;">3150</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">111</td>
<td style="text-align: left; user-select: auto !important;">orange</td>
<td style="user-select: auto !important;">2900</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">112</td>
<td style="text-align: left; user-select: auto !important;">pineapple</td>
<td style="user-select: auto !important;">2900</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;"><code style="user-select: auto !important;">JULY</code>테이블이 다음과 같다면</p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="text-align: left; user-select: auto !important;">SHIPMENT_ID</th>
<th style="text-align: left; user-select: auto !important;">FLAVOR</th>
<th style="user-select: auto !important;">TOTAL_ORDER</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">101</td>
<td style="text-align: left; user-select: auto !important;">chocolate</td>
<td style="user-select: auto !important;">520</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">102</td>
<td style="text-align: left; user-select: auto !important;">vanilla</td>
<td style="user-select: auto !important;">560</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">103</td>
<td style="text-align: left; user-select: auto !important;">mint_chocolate</td>
<td style="user-select: auto !important;">400</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">104</td>
<td style="text-align: left; user-select: auto !important;">caramel</td>
<td style="user-select: auto !important;">460</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">105</td>
<td style="text-align: left; user-select: auto !important;">white_chocolate</td>
<td style="user-select: auto !important;">350</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">106</td>
<td style="text-align: left; user-select: auto !important;">peach</td>
<td style="user-select: auto !important;">500</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">107</td>
<td style="text-align: left; user-select: auto !important;">watermelon</td>
<td style="user-select: auto !important;">780</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">108</td>
<td style="text-align: left; user-select: auto !important;">mango</td>
<td style="user-select: auto !important;">790</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">109</td>
<td style="text-align: left; user-select: auto !important;">strawberry</td>
<td style="user-select: auto !important;">520</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">110</td>
<td style="text-align: left; user-select: auto !important;">melon</td>
<td style="user-select: auto !important;">400</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">111</td>
<td style="text-align: left; user-select: auto !important;">orange</td>
<td style="user-select: auto !important;">250</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">112</td>
<td style="text-align: left; user-select: auto !important;">pineapple</td>
<td style="user-select: auto !important;">200</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">208</td>
<td style="text-align: left; user-select: auto !important;">mango</td>
<td style="user-select: auto !important;">110</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">209</td>
<td style="text-align: left; user-select: auto !important;">strawberry</td>
<td style="user-select: auto !important;">220</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto !important;">7월 아이스크림 총주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회하면 strawberry(520 + 220 + 3,100 = 3,840), mango(790 + 110 + 2,900 = 3,800), chocolate(520 + 3,200 = 3,720) 순입니다. 따라서 SQL 문을 실행하면 다음과 같이 나와야 합니다. </p>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="text-align: left; user-select: auto !important;">FLAVOR</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">strawberry</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">mango</td>
</tr>
<tr style="user-select: auto !important;">
<td style="text-align: left; user-select: auto !important;">chocolate</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges