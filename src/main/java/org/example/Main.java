package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();

        System.out.println("== 프로그램을 시작합니다 ! ==");
        Scanner sc = new Scanner(System.in);
        int lastPostId = 0;
        while (true){
            System.out.print("명령어 입력 : ");
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
                posts.add(post);
                System.out.println("게시물이 작성되었습니다.");
            }
            else if(cmd.equals("post list")){
                if (posts.size() == 0){
                    System.out.println("게시물이 존재하지 않습니다.");
                    continue;
                }
                else {
                    System.out.println("번호 | 제목");
                    for(int i = 0; i<posts.size(); i++){
                        Post post = posts.get(i);

                        System.out.printf("%4d | %4s\n",post.id,post.title);
                    }
                }
            }
            else if (cmd.startsWith("post detail")){
                String[] cmdBits = cmd.split(" ");
                int id = Integer.parseInt(cmdBits[2]);
                Post foundPost = null;

                for (int i =0; i<posts.size(); i++) {
                    Post post = posts.get(i);

                    if(post.id == id){
                        foundPost = post;
                        break;
                    }
                }

                if (foundPost == null){
                    System.out.println("존재하지 않는 게시물 입니다.");
                    continue;
                }
                System.out.printf("번호 : %d\n", foundPost.id);
                System.out.printf("제목 : %s\n", foundPost.title);
                System.out.printf("내용 : %s\n", foundPost.body);
            }

            else if (cmd.startsWith("post delete")){
                String[] cmdBits = cmd.split(" ");
                int id = Integer.parseInt(cmdBits[2]);
                int foundIndex = -1;

                for (int i = 0; i< posts.size(); i++){
                    Post post = posts.get(i);

                    if(post.id == id){
                        foundIndex = i;
                        break;
                    }
                }
                if (foundIndex == -1){
                    System.out.println("존재하지 않는 게시물 입니다.");
                }
                posts.remove(foundIndex);
                System.out.printf("%s번 게시물이 삭제 되었습니다.\n", id);
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

