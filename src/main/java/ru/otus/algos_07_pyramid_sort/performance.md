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
      <td>ShakerSort</td>
      <td>Шейкер-сортировка - 100 элементов</td>
      <td>5</td>
      <td>120.135</td>
      <td>10.994</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShakerSort</td>
      <td>Шейкер-сортировка - 1000 элементов</td>
      <td>5</td>
      <td>2.052</td>
      <td>0.280</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShakerSort</td>
      <td>Шейкер-сортировка - 10000 элементов</td>
      <td>5</td>
      <td>0.018</td>
      <td>0.001</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShakerSort</td>
      <td>Шейкер-сортировка - 100000 элементов</td>
      <td>5</td>
      <td>0.0001</td>
      <td>Не определилась</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShakerSort</td>
      <td>Шейкер-сортировка - 1000000 элементов</td>
      <td>5</td>
      <td>Дольше 2-х минут не стала ждать результата</td>
      <td></td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>SelectionSort</td>
      <td>Сортировка выбором - 100 элементов</td>
      <td>5</td>
      <td>164.626</td>
      <td>16.202</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>SelectionSort</td>
      <td>Сортировка выбором - 1000 элементов</td>
      <td>5</td>
      <td>3.446</td>
      <td>0.564</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>SelectionSort</td>
      <td>Сортировка выбором - 10000 элементов</td>
      <td>5</td>
      <td>0.040</td>
      <td>0.003</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>SelectionSort</td>
      <td>Сортировка выбором - 100000 элементов</td>
      <td>5</td>
      <td>0.001</td>
      <td>Не указано</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>SelectionSort</td>
      <td>Сортировка выбором - 1000000 элементов</td>
      <td>5</td>
      <td>Дольше 2-х минут не стала ждать</td>
      <td> </td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>HeapSort</td>
      <td>Пирамидальная сортировка - 100 элементов</td>
      <td>5</td>
      <td>187.206</td>
      <td>66.540</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>HeapSort</td>
      <td>Пирамидальная сортировка - 1000 элементов</td>
      <td>5</td>
      <td>17.750</td>
      <td>1.601</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>HeapSort</td>
      <td>Пирамидальная сортировка - 10000 элементов</td>
      <td>5</td>
      <td>1.365</td>
      <td>0.161</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>HeapSort</td>
      <td>Пирамидальная сортировка - 100000 элементов</td>
      <td>5</td>
      <td>0.123</td>
      <td>0.022</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>HeapSort</td>
      <td>Пирамидальная сортировка - 1000000 элементов</td>
      <td>5</td>
      <td>0.011</td>
      <td>0.001</td>
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

* Сортировка выбором и шейкер-сортировка приемлемы только на небольших объемах (до нескольких тысяч элементов).
* Пирамидальная сортировка демонстрирует лучшую производительность на больших объёмах данных.
* На больших данных (от 100 тысяч и выше) пирамидальная сортировка значительно выигрывает по времени работы, 
  только она завершается быстро при 1 миллионе элементов.
Тест проводился несколько раз на одинаковых данных.