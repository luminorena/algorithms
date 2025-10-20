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
      <td>SplayTree</td>
      <td>Рандомные числа в дереве - вставка 100 элементов</td>
      <td>5</td>
      <td>8586.788</td>
      <td>306.940</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>SplayTree</td>
      <td>Рандомные числа в дереве - поиск в 100 элементов</td>
      <td>5</td>
      <td>4873.719</td>
      <td>494.722</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>SplayTree</td>
      <td>Рандомные числа в дереве - вставка 1000 элементов</td>
      <td>5</td>
      <td>5573.280</td>
      <td>169.618</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>SplayTree</td>
      <td>Рандомные числа в дереве - поиск в 1000 элементов</td>
      <td>5</td>
      <td>3212.064</td>
      <td>219.207</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>SplayTree</td>
      <td>Последовательные числа в дереве - вставка 100 элементов</td>
      <td>5</td>
      <td>33470.906</td>
      <td>1248.650</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>SplayTree</td>
      <td>Последовательные числа в дереве - поиск в 100 элементов</td>
      <td>5</td>
      <td>7804.295</td>
      <td>605.191</td>
      <td>ops/ms</td>
    </tr>
    <tr>
    <tr>
      <td>SplayTree</td>
      <td>Последовательные числа в дереве - вставка 1000 элементов</td>
      <td>5</td>
      <td>30247.393</td>
      <td>1286.583</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>SplayTree</td>
      <td>Последовательные числа в дереве - поиск в 1000 элементов</td>
      <td>5</td>
      <td>7191.083</td>
      <td>616.046</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>RandomTree</td>
      <td>Рандомные числа в дереве - вставка 100 элементов</td>
      <td>5</td>
      <td>5036.735</td>
      <td>338.516</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>RandomTree</td>
      <td>Рандомные числа в дереве - поиск в 100 элементов</td>
      <td>5</td>
      <td>8944.378</td>
      <td>1245.792</td>
      <td>ops/ms</td>
    </tr>
   <tr>
      <td>RandomTree</td>
      <td>Рандомные числа в дереве - вставка 1000 элементов</td>
      <td>5</td>
      <td>3866.996</td>
      <td>378.011</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>RandomTree</td>
      <td>Рандомные числа в дереве - поиск в 1000 элементов</td>
      <td>5</td>
      <td>5470.600</td>
      <td>354.525</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>RandomTree</td>
      <td>Последовательные числа в дереве - вставка 100 элементов</td>
      <td>5</td>
      <td >6487.609</td>
      <td>708.134</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>RandomTree</td>
      <td>Последовательные числа в дереве - поиск 100 элементов</td>
      <td>5</td>
      <td>30597.733</td>
      <td>749.969</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>RandomTree</td>
      <td>Последовательные числа в дереве - вставка 1000 элементов</td>
      <td>5</td>
      <td>6324.257</td>
      <td>613.093</td>
      <td>ops/ms</td>
    </tr>
    <tr>
      <td>RandomTree</td>
      <td>Последовательные числа в дереве - поиск 1000 элементов</td>
      <td>5</td>
      <td>29190.762</td>
      <td>547.713</td>
      <td>ops/ms</td>
    </tr>
  </tbody>
</table>


<h3>Результаты</h3>



* SplayTree хорошо справляется со вставкой последовательных чисел и уступает по вставке рандомных чисел RandomTree.
* RandomTree демонстрирует высокую производительность поиска для последовательных данных.
* Для задач с большими объемами и последовательными элементами SplayTree предпочтительнее по вставке, а RandomTree — по поиску.

Тест проводился несколько раз на одинаковых данных.