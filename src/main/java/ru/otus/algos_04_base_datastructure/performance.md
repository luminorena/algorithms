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
      <td>FactorArrayBenchmark.benchmarkAdd</td>
      <td>Динамический х2, добавление</td>
      <td>5</td>
      <td>21718.352</td>
      <td>333.269</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>FactorArrayBenchmark.benchmarkRemove</td>
      <td>Динамический х2, удаление</td>
      <td>5</td>
      <td>21867.094</td>
      <td>10930.985</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>MatrixArrayBenchmark.benchmarkAdd</td>
      <td>Свободный, добавление</td>
      <td>5</td>
      <td>43740.419</td>
      <td>6152.631</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>MatrixArrayBenchmark.benchmarkRemove</td>
      <td>Свободный, удаление</td>
      <td>5</td>
      <td>37916.216</td>
      <td>5205.502</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>MatrixArrayListBenchmark.benchmarkAdd</td>
      <td>Массив ссылок на записи элементов строк, добавление</td>
      <td>5</td>
      <td>42024.942</td>
      <td>1340.540</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>MatrixArrayListBenchmark.benchmarkRemove</td>
      <td>Массив ссылок на записи элементов строк, удаление</td>
      <td>5</td>
      <td>41833.124</td>
      <td>2185.559</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>SingleArrayBenchmark.benchmarkAdd</td>
      <td>Динамический +1, добавление</td>
      <td>5</td>
      <td>21816.919</td>
      <td>3417.908</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>SingleArrayBenchmark.benchmarkRemove</td>
      <td>Динамический +1, удаление</td>
      <td>5</td>
      <td>24903.380</td>
      <td>1067.458</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>VectorArrayBenchmark.benchmarkAdd</td>
       <td>Динамический +100, добавление</td>
      <td>5</td>
      <td>17211.189</td>
      <td>990.139</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>VectorArrayBenchmark.benchmarkRemove</td>
       <td>Динамический +100, удаление</td>
      <td>5</td>
      <td>44113.405</td>
      <td>270.594</td>
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

Тест производительности показал, что самый лучший результат имеет VectorArrayBenchmark.benchmarkAdd (Динамический +100, добавление), 
а самый худший - VectorArrayBenchmark.benchmarkRemove (Динамический +100, удаление). 
Тест проводился несколько раз на одинаковых данных. Увеличение количества итераций результат не улучшает. 
Интересно, что если увеличить количество потоков, то результат сильно ухудшается. Самый стабильный результат, что в плане разброса между удалением и добавлением, 
что в плане показателя, имеет FactorArrayBenchmark, что на добавление, что на удвление элемента. 