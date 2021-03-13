package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
     System.out.println("Введите строку");
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     String str=reader.readLine();
     String newstr="";
     String newstr1="";
     int x=0,countiteration=0,countsymbols=0;
     ArrayList<Character> arrayStr = new ArrayList<Character>();
     for(int i=0;i<str.length();i++){//заполнение массива символами строки
        char c = str.charAt(i);
        arrayStr.add(c);
        if(str.charAt(i)=='['){
            x++;
        } }
     for (int i = 0; i < arrayStr.size(); i++) { //проверка на валидность(строка удовлетворяет условиям)
         if(Character.isDigit(arrayStr.get(i)) || Character.isLetter(arrayStr.get(i)) || arrayStr.get(i)=='[' || arrayStr.get(i)==']'){
             countsymbols++;
            }
        }
     if(countsymbols==arrayStr.size()){
         boolean flag=true;
         int lindex = arrayStr.lastIndexOf('[');
         int findex = arrayStr.indexOf(']');
         if(lindex< findex)
         { flag=true;}
         else{flag=false;}
         while(countiteration!=x) {//цикл на раскрытие всех скобок
             if(flag==false){//если невложенные скобки
                 lindex = arrayStr.lastIndexOf('[');
                 findex = arrayStr.lastIndexOf(']');
             }else{//если вложенные скобки
                 lindex=arrayStr.lastIndexOf('[');
                 findex= arrayStr.indexOf(']');
             }
             int kolvo=0;
             try {
                 kolvo = Integer.valueOf(String.valueOf(arrayStr.get(lindex - 1))); }
             catch (Exception e){
                 System.out.println("Несоблюдены правила ввода строки - перед скобкой не цифра");
             }
             int kolvosymb = 0;
             for (int j = lindex + 1; j < arrayStr.size() - (arrayStr.size() - findex); j++) {
                 kolvosymb++;
                 newstr = newstr + arrayStr.get(j);//запись в строку содержимого одной скобки
             }
             int count = 0,count1=0;
             while (count != kolvo) {//запись в строку содержимого одной строки в зависимости от числа повторений
                 newstr1 = newstr1 + newstr;
                 count++;
             }
             ArrayList<Character> arrayNewstr1 = new ArrayList<Character>();
             for (int i = 0; i < newstr1.length(); i++) {
                 char c = newstr1.charAt(i);
                 arrayNewstr1.add(c);
             }
             while (count1 != kolvosymb + 3) {//удаление символов
                 arrayStr.remove(lindex - 1);
                 count1++;
             }
             for (int j = 0; j < arrayNewstr1.size(); j++) {//добавление символов взамен удаленных
                 arrayStr.add(lindex - 1, arrayNewstr1.get(j));
             }
             countiteration++;
             newstr="";
             newstr1="";
         }
         str="";
         for(int i =0;i<arrayStr.size();i++){
             str=str+arrayStr.get(i);
         }
         if(flag==true){System.out.println(new StringBuilder(str).reverse().toString());}
         else{System.out.println(str);}
     }else System.out.println("Некорректно введена строка");
    }
}