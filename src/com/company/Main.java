package com.company;

public class Main {
    public static void main(String[] args)
            {
                String strok = "1 2 3 В Республике Беларусь за 1-ый квартал 2 019 года зафиксировано 11 123 брака и 8 570 разводов, а за 9 550 браков и 9 000 разводов123";
                String strok1="";
                boolean gh = false;


                for (int i=0; i<strok.length() - 1;i++) // заходим в цикл (начиная с 1 элемента, до последнего)
                {
                    if(strok.charAt(i)>=47&&strok.charAt(i)<=58) // таблица Аски, проверяешь условие цифры ли
                    {
                        strok1+=strok.charAt(i); // записываем в строку
                        gh = true;
                    }
                    if (gh) // если тру
                    {
                        if(strok.charAt(i + 1) == 32) // следующий элемент пробел
                        { if (i != strok.length() - 1) // чтобы не выйти за размерность
                        {
                            if(!(strok.charAt(i+2)>=47&&strok.charAt(i+2)<=58) || strok.charAt(i+3)==32) // не цисло или пробел
                            {
                                ann(strok1); // вызываем функцию
                                strok1=""; // очищаем строку
                                gh = false;
                            }
                            if (i == strok.length() - 1) // если это конец
                            {
                                ann(strok1);
                            }

                            if (i == strok.length() - 1 && strok.charAt(i)>=47&&strok.charAt(i)<=58) // если конец и число
                            {
                                ann(strok1);
                            }
                        }
                        }
                    }
                }

            }
            public static void ann (String s)
            {
                int l = 0;
                int x = Integer.parseInt(s); // преобразовывает в число
                double res = 0;
                res = Math.pow((Math.pow (x,2) - 6 *x ),2) - 2 * Math.pow((x - 3),2) - 81; // считаем многочлен
                System.out.println("Число:" + x + " "+ "Значение:" + res);
                do
                { if (x%2 ==0) // чётное
                {
                    x= x/2;
                    l++;
                }

                else
                {

                    x = x*3 + 1; // нечётное
                    l++;
                }
                }
                while(x != 4);
                System.out.println("Количество итераций" + l);
            }
        }
