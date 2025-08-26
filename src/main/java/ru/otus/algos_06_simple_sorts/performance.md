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
      <td>BubbleSortSimple</td>
      <td>Простой алгоритм сортировки пузырьком - 100 элементов</td>
      <td>5</td>
      <td>84.722</td>
      <td>11.685</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>BubbleSortSimple</td>
      <td>Простой алгоритм сортировки пузырьком - 1000 элементов</td>
      <td>5</td>
      <td>1.801</td>
      <td>0.286</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>BubbleSortSimple</td>
      <td>Простой алгоритм сортировки пузырьком - 10000 элементов</td>
      <td>5</td>
      <td>0.015</td>
      <td>0.001</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>BubbleSortOptimized</td>
      <td>Оптимизировнный алгоритм сортировки пузырьком - 100 элементов</td>
      <td>5</td>
      <td>72.336</td>
      <td>4.883</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>BubbleSortOptimized</td>
      <td>Оптимизировнный алгоритм сортировки пузырьком - 1000 элементов</td>
      <td>5</td>
      <td>1.373</td>
      <td>0.147</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>BubbleSortOptimized</td>
      <td>Оптимизировнный алгоритм сортировки пузырьком - 10000 элементов</td>
      <td>5</td>
      <td>0.011</td>
      <td>0.001</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>BubbleSortOptimized</td>
      <td>Оптимизировнный алгоритм сортировки пузырьком - 100000 элементов</td>
      <td>5</td>
      <td>0.0001</td>
      <td>не указано</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>BubbleSortOptimized</td>
      <td>Оптимизировнный алгоритм сортировки пузырьком - 1000000 элементов</td>
      <td>5</td>
      <td>Дольше 2х минут не стала ждать</td>
      <td>не указано</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>InsertionSortSimple</td>
      <td>Простой алгоритм сортирови вставками - 100 элементов</td>
      <td>5</td>
      <td>261.427</td>
      <td>23.689</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>InsertionSortSimple</td>
      <td>Простой алгоритм сортирови вставками - 1000 элементов</td>
      <td>5</td>
      <td>3.383</td>
      <td>0.256</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>InsertionSortSimple</td>
      <td>Простой алгоритм сортирови вставками - 10000 элементов</td>
      <td>5</td>
      <td>0.035</td>
      <td>0.002</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>InsertionSortSimple</td>
      <td>Простой алгоритм сортирови вставками - 100000 элементов</td>
      <td>5</td>
      <td>0.0001</td>
      <td>Не указано</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>InsertionSortSimple</td>
      <td>Простой алгоритм сортирови вставками - 1000000 элементов</td>
      <td>5</td>
      <td>Дольше 2-х минут не стала ждать результата</td>
      <td>Не указано</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>InsertionSortMovesReduced</td>
      <td>Алгоритм сортировки вставками с оптимизацией перемещений - 100</td>
      <td>5</td>
      <td>446.968</td>
      <td>49.105</td>
      <td>ops/ms</td>
    </tr>
     <tr>
      <td>InsertionSortMovesReduced</td>
      <td>Алгоритм сортировки вставками с оптимизацией перемещений - 1000</td>
      <td>5</td>
      <td>9.244</td>
      <td>3.632</td>
      <td>ops/ms</td>
    </tr>
     <tr>
      <td>InsertionSortMovesReduced</td>
      <td>Алгоритм сортировки вставками с оптимизацией перемещений - 10000</td>
      <td>5</td>
      <td>0.140</td>
      <td>0.020</td>
      <td>ops/ms</td>
    </tr>
     <tr>
      <td>InsertionSortMovesReduced</td>
      <td>Алгоритм сортировки вставками с оптимизацией перемещений - 100000 элементоа</td>
      <td>5</td>
      <td>0.001</td>
      <td>0.001</td>
      <td>ops/ms</td>
    </tr>
     <tr>
      <td>InsertionSortMovesReduced</td>
      <td>Алгоритм сортировки вставками с оптимизацией перемещений - 1000000 элементов</td>
      <td>5</td>
      <td>Дольше 2-х минут не стала ждать результата</td>
      <td>Не указано</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>InsertionSortBinarySearch</td>
      <td>Алгоритм сортировки вставками с оптимизацией бинарного поиска - 100 элементов</td>
      <td>5</td>
      <td>159.160</td>
      <td>31.161</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>InsertionSortBinarySearch</td>
      <td>Алгоритм сортировки вставками с оптимизацией бинарного поиска - 1000 элементов</td>
      <td>5</td>
      <td>3.324</td>
      <td>0.720</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>InsertionSortBinarySearch</td>
      <td>Алгоритм сортировки вставками с оптимизацией бинарного поиска - 10000 элементов</td>
      <td>5</td>
      <td>0.037</td>
      <td>0.001</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>InsertionSortBinarySearch</td>
      <td>Алгоритм сортировки вставками с оптимизацией бинарного поиска - 100000 элементов</td>
      <td>5</td>
      <td>0.001</td>
      <td>не определено</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>InsertionSortBinarySearch</td>
      <td>Алгоритм сортировки вставками с оптимизацией бинарного поиска - 1000000 элементов</td>
      <td>5</td>
      <td>Дольше 2-х минут не стала ждать результата</td>
      <td>Не указано</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShellSortSimple</td>
      <td>Простой алгоритм сортировки Шелла - 100 элементов</td>
      <td>5</td>
      <td>303.303</td>
      <td>16.839</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShellSortSimple</td>
      <td>Простой алгоритм сортировки Шелла - 1000 элементов</td>
      <td>5</td>
      <td>21.623</td>
      <td>0.265</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShellSortSimple</td>
      <td>Простой алгоритм сортировки Шелла - 10000 элементов</td>
      <td>5</td>
      <td>1.599</td>
      <td>0.156</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShellSortOptimizedFirstVariant</td>
      <td>Оптимизированный алгоритм сортировки Шелла, 1й вариант выбора шагов - 100 элементов</td>
      <td>5</td>
      <td>332.602</td>
      <td>19.440</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShellSortOptimizedFirstVariant</td>
      <td>Оптимизированный алгоритм сортировки Шелла, 1й вариант выбора шагов - 1000 элементов</td>
      <td>5</td>
      <td>19.780</td>
      <td>1.038</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShellSortOptimizedFirstVariant</td>
      <td>Оптимизированный алгоритм сортировки Шелла, 1й вариант выбора шагов - 10000 элементов</td>
      <td>5</td>
      <td>1.347</td>
      <td>0.294</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShellSortOptimizedFirstVariant</td>
      <td>Оптимизированный алгоритм сортировки Шелла, 1й вариант выбора шагов - 100000 элементов</td>
      <td>5</td>
      <td>0.143</td>
      <td>0.008</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShellSortOptimizedFirstVariant</td>
      <td>Оптимизированный алгоритм сортировки Шелла, 1й вариант выбора шагов - 1000000 элементов</td>
      <td>5</td>
      <td>0.012</td>
      <td>0.001</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShellSortOptimizedSecondVariant</td>
      <td>Оптимизированный алгоритм сортировки Шелла, 2й вариант выбора шагов - 100 элементов</td>
      <td>5</td>
      <td>323.457</td>
      <td>12.716</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShellSortOptimizedSecondVariant</td>
      <td>Оптимизированный алгоритм сортировки Шелла, 2й вариант выбора шагов - 1000 элементов</td>
      <td>5</td>
      <td>20.029</td>  
      <td>0.874</td> 
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShellSortOptimizedSecondVariant</td>
      <td>Оптимизированный алгоритм сортировки Шелла, 2й вариант выбора шагов - 10000 элементов</td>
      <td>5</td>
      <td>1.647</td>
      <td>0.056</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShellSortOptimizedSecondVariant</td>
      <td>Оптимизированный алгоритм сортировки Шелла, 2й вариант выбора шагов - 100000 элементов</td>
      <td>5</td>
      <td>0.149</td>
      <td>0.006</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>ShellSortOptimizedSecondVariant</td>
      <td>Оптимизированный алгоритм сортировки Шелла, 2й вариант выбора шагов - 1000000 элементов</td>
      <td>5</td>
      <td>0.012</td>
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



* Алгоритмы пузырьковой сортировки (BubbleSort) очень медленные и плохо масштабируемые с ростом размера данных, даже оптимизированный вариант.
* Вставки (InsertionSort) значительно быстрее пузырьковой сортировки на малых объемах, особенно при оптимизациях перемещений, но при больших объемах также сильно деградируют и не применимы к миллиону элементов.
* Сортировка Шелла (ShellSort) работает значительно быстрее и лучше масштабируется, особенно оптимизированные варианты, и применима даже к миллиону элементов с приемлемой пропускной способностью.
* Среди всех тестируемых алгоритмов для больших объемов данных (100000 и более элементов) именно оптимизированные варианты ShellSort являются оптимальным выбором.

Тест проводился несколько раз на одинаковых данных.