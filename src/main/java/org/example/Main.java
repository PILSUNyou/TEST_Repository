package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 프로그램을 시작합니다 ! ==");
        Scanner sc = new Scanner(System.in);
        int lastPostId = 0;
        while (true){
            System.out.println("명령어 입력 : ");
            String cmd = sc.nextLine();

            if (cmd.length() == 0){
                System.out.print("명령어를 입력해 주십시오.");
                continue;
            }
            if (cmd.equals("exit")){
                break;
            }
            else if(cmd.equals("post write")){
                int id = lastPostId + 1;
                lastPostId = id;
                System.out.print("게시글의 제목을 입력해주세요 : ");
                String title = sc.nextLine();
                System.out.print("게시글의 내용을 입력해주세요 : ");
                String body = sc.nextLine();

                Post post = new Post(id, title, body);
                System.out.println("게시물이 작성되었습니다.");
            }
            else if(cmd.equals("post list")){
                System.out.println("게시물이 존재하지 않습니다.");
            }

            else{
                System.out.println("잘못된 입력입니다.");
                continue;
            }
        }
        sc.close();
        System.out.println("== 프로그램을 종료합니다 ! ==");

    }
}

