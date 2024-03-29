package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Post> posts;
    static {
        posts = new ArrayList<>();
    }
    public static void main(String[] args) {
        System.out.println("== 프로그램을 시작합니다 ! ==");

        makeTestData();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("명령어 입력 : ");
            String cmd = sc.nextLine();

            if (cmd.length() == 0) {
                System.out.print("명령어를 입력해 주십시오.");
                continue;
            }
            if (cmd.equals("exit")) {
                break;
            } else if (cmd.equals("post write")) {
                int id = posts.size() + 1;
                String  regDate = util.getNowDateStr();
                System.out.print("게시글의 제목을 입력해주세요 : ");
                String title = sc.nextLine();
                System.out.print("게시글의 내용을 입력해주세요 : ");
                String body = sc.nextLine();

                Post post = new Post(id, regDate, title, body);
                posts.add(post);
                System.out.printf("%d번 게시물이 작성되었습니다.\n",id);
            } else if (cmd.equals("post list")) {
                if (posts.size() == 0) {
                    System.out.println("게시물이 존재하지 않습니다.");
                    continue;
                } else {
                    System.out.println("번호 | 조회 | 제목");
                    for (int i = 0; i < posts.size(); i++) {
                        Post post = posts.get(i);

                        System.out.printf("%4d | %4d | %4s\n", post.id, post.hit,post.title);
                    }
                }
            } else if (cmd.startsWith("post detail")) {
                String[] cmdBits = cmd.split(" ");
                int id = Integer.parseInt(cmdBits[2]);
                Post foundPost = null;

                for (int i = 0; i < posts.size(); i++) {
                    Post post = posts.get(i);

                    if (post.id == id) {
                        foundPost = post;
                        break;
                    }
                }

                if (foundPost == null) {
                    System.out.println("존재하지 않는 게시물 입니다.");
                    continue;
                }
                foundPost.increaseHit();
                System.out.printf("번호 : %d\n", foundPost.id);
                System.out.printf("날짜 : %s\n", foundPost.regDate);
                System.out.printf("제목 : %s\n", foundPost.title);
                System.out.printf("내용 : %s\n", foundPost.body);
                System.out.printf("조회 : %d\n", foundPost.hit);
            } else if (cmd.startsWith("post delete")) {
                String[] cmdBits = cmd.split(" ");
                int id = Integer.parseInt(cmdBits[2]);
                int foundIndex = -1;

                for (int i = 0; i < posts.size(); i++) {
                    Post post = posts.get(i);

                    if (post.id == id) {
                        foundIndex = i;
                        break;
                    }
                }
                if (foundIndex == -1) {
                    System.out.println("존재하지 않는 게시물 입니다.");
                }
                posts.remove(foundIndex);
                System.out.printf("%s번 게시물이 삭제 되었습니다.\n", id);
            }
            else if (cmd.equals("post modify")){
                String[] cmdBits = cmd.split(" ");
                int id = Integer.parseInt(cmdBits[2]);
                Post foundPost = null;

                for (int i =0; i<posts.size(); i++){
                    Post post = posts.get(i);

                    if (post.id == id){
                        foundPost = post;
                        break;
                    }
                }
                if (foundPost == null){
                    System.out.printf("%d번 게시물은 존재하지 않습니다.",id);
                    continue;
                }
                System.out.printf("수정할 제목 입력\n");
                String title = sc.nextLine();
                System.out.printf("수정할 내용 입력\n");
                String body = sc.nextLine();

                foundPost.title = title;
                foundPost.body = body;
                System.out.printf("%d번 게시물이 수정되었습니다.",id);
            }
            else {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

        }
        sc.close();
        System.out.println("== 프로그램을 종료합니다 ! ==");

    }

    private static void makeTestData() {
        System.out.println("테스트를 위한 게시물데이터를 생성합니다.");
        posts.add(new Post(1,util.getNowDateStr(), "제목 1", "내용 1"));
        posts.add(new Post(2,util.getNowDateStr(), "제목 2", "내용 2"));
        posts.add(new Post(3,util.getNowDateStr(), "제목 3", "내용 3"));
    }
}