<h2>Таблица сравнения производительности</h2>

Тесты были сделаны с помощью бенчмаркинга.

<h3>Характеристики hardware перед проведение тестов</h3>

Processor	11th Gen Intel(R) Core(TM) i7-1165G7 2.80 GHz <br>
Installed RAM	32.0 GB (31.7 GB usable) <br>
System type	64-bit operating system, x64-based processor <br>

<h3>Результаты</h3>

<table border="1" cellspacing="3" cellpadding="7">
  <thead>
    <tr>
      <th>Benchmark</th>
      <th>Description</th>
      <th>Cnt</th>
      <th>Score</th>
      <th>Error</th>
      <th>Units</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>BucketSort</td>
      <td>Алгоритм блочной сортировки - 100 элементов</td>
      <td>5</td>
      <td>215.075</td>
      <td>8.011</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>BucketSort</td>
      <td>Алгоритм блочной сортировки - 1000 элементов</td>
      <td>5</td>
      <td>17.669</td>
      <td>0.946</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>BucketSort</td>
      <td>Алгоритм блочной сортировки - 10000 элементов</td>
      <td>5</td>
      <td>1.218</td>
      <td>0.074</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>BucketSort</td>
      <td>Алгоритм блочной сортировки - 100000 элементов</td>
      <td>5</td>
      <td>0.060</td>
      <td>0.006</td>
      <td>ops/ms</td>
    </tr>
    <tr>
     <td>BucketSort</td>
      <td>Алгоритм блочной сортировки - 1000000 элементов</td>
      <td>5</td>
      <td>0.008</td>
      <td>0.001</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>RadixSort</td>
      <td>Алгоритм поразрядной сортировки - 100 элементов</td>
      <td>5</td>
      <td>320.145</td>
      <td>39.643</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>RadixSort</td>
      <td>Алгоритм поразрядной сортировки - 1000 элементов</td>
      <td>5</td>
      <td>32.564</td>
      <td>2.258</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>RadixSort</td>
      <td>Алгоритм поразрядной сортировки - 10000 элементов</td>
      <td>5</td>
      <td>3.108</td>
      <td>0.670</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>RadixSort</td>
      <td>Алгоритм поразрядной сортировки - 100000 элементов</td>
      <td>5</td>
      <td>0.313</td>
      <td>0.016</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>RadixSort</td>
      <td>Алгоритм поразрядной сортировки - 1000000 элементов</td>
      <td>5</td>
      <td>0.030</td>
      <td>0.002</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>CountingSort</td>
      <td>Алгоритм сортировки подсчётом - 100 элементов</td>
      <td>5</td>
      <td>1142.356</td>
      <td>75.166</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>CountingSort</td>
      <td>Алгоритм сортировки подсчётом - 1000 элементов</td>
      <td>5</td>
      <td>272.390</td>
      <td>36.157</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>CountingSort</td>
      <td>Алгоритм сортировки подсчётом - 10000 элементов</td>
      <td>5</td>
      <td>23.162</td>
      <td>0.988</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>CountingSort</td>
      <td>Алгоритм сортировки подсчётом - 100000 элементов</td>
      <td>5</td>
      <td>1.747</td>
      <td>0.119</td>
      <td>ops/ms</td>
    </tr>
     <tr>
      <td>CountingSort</td>
      <td>Алгоритм сортировки подсчётом - 1000000 элементов</td>
      <td>5</td>
      <td>0.137</td>
      <td>0.003</td>
      <td>ops/ms</td>
    </tr>
     
  </tbody>
</table>


 <h3>Описание</h3>
 
<h3>Предварительные условия</h3>

* Прогрев JVM: 3 итерации
* Измерения: 5 iterations, 10 s each
* Timeout: 10 min per iteration
* Threads: 1 thread, will synchronize iterations
* Benchmark mode: Throughput, ops/time

<h3>Результаты</h3>

* Алгоритм CountingSort показал наилучшую производительность при небольших объемах данных 
  (100 и 1000 элементов), достигая значений до 1142 операций/мс. С увеличением размера данных 
  скорость существенно снижается, но остается выше, чем у других алгоритмов для больших наборов.
* RadixSort демонстрирует более высокую производительность по сравнению с BucketSort на всех объемах
  данных, особенно на малых и средних размерах массива (до 10 000 элементов).
* BucketSort уступает остальным алгоритмам во всех тестах, особенно заметно при больших объемах данных,
  где скорость падает до 0.008 ops/ms для миллиона элементов.

Вывод: для малых объемов данных эффективнее получается CountingSort, для средних и больших - RadixSort,
а BucketSort является менее производительным вариантом.

Тест проводился несколько раз на одинаковых данных.