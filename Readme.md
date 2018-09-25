# Лабораторные работы по иммитационному моделированию

1. Лаба 1
Построить графики

2. Лаба 2
- Заполнение колонок табличными значениями
- Заполнение колонок алгоритмическим способом
- Создание критерия, по которому предстояло бы определять случайность выборки чисел

Имеется некоторая последовательность чисел. Требуется оценить, насколько она случайна. Как это сделать каким-то образом? Сейчас есть такая штука:

1) нахожу разности между соседними членами последовательности
получается новая последовательность

2) подсчитываю количество совпадений в новой последовательности
получается третья последовательность 

3) выбираю максимальный член этой последовательности

4) оценка = этот_максимальный_член / количество_членов_в_первоначальной_последовательности * 10

3. Лаба 3
Цель данной работы - найти среднее относительное время пребывания системы в каждом состоянии (при установившемся режиме работы).
Для решения данной задачи необходимо от заданной матрицы интенсивностей перехода из состояния в состояние перейти к уравнениям Колмогорова.

4. Лаба 4
Цель данной работы - смоделировать систему, состоящую из генератора, источника информации, блока памяти и обслуживающего аппарата.
Закон генерации заявок – равномерный.
В обслуживающем аппарате - закон распределение Пуассона.
Необходимо определить минимальный размер буферной памяти, т.е. ту длину, при которой ни одно сообщение необработанным не останется (т.е. нет отказа).
Также необходимо предусмотреть возможность возвращения заявки в очередь после ее обработки.
При реализации использовать два подхода:
— событийный
— ∆𝑡 (ориентирован на действие)

5. Лаба 5
Цель данной работы - смоделировать работу информационного центра.
В информационный центр приходят клиенты через интервалы времени (∆𝑡) 10±2 минуты.
В информационном центре три оператора. Если все три имеющихся оператора заняты, то клиенту отказывают в обслуживании.
Операторы имеют производительность соответственно:
- 20±5 мин,
- 40±10 мин,
- 40±20 мин.
Клиенты стараются занять свободного оператора с максимальной производительностью.
Полученные запросы сдаются в приемный накопитель, откуда выбираются для обработки на первый компьютер (время обработки 15 минут на заявку) для 1 и 2 оператора и на второй компьютер (время обработки 30 минут на заявку) для 3-го оператора.
Необходимо:
1)	Смоделировать процесс обработки для 300 запросов.
2)	Определить вероятность отказа.
3)	Предусмотреть 300 как на входе, так и на выходе. 
У компьютеров очереди бесконечные. Оператор освобождается, когда он передаст заявку компьютеру.
