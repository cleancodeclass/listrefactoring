# OpenSource Contributions

## Git 활용 Tips
### Git 명령어
1. 커밋 메세지 확인
    ```
    $ git log
    ```
1. 커밋 메세지 첫줄만 확인
    ```
    $ git log --pretty=short
    ```
1. 브랜치 시각적 확인
    ```
    $ git log --graph
    ```
1. 변경내역 확인
    ```
    $ git diff
    ```
1. 브랜치 보는법
    ```
    $ git branch [-a|-r]
    ```
1. 브랜치 변경
    ```
    $ git checkout [BRANCH_NAME] 
    ```
1. 브랜치 생성 후 변경
    ```
    $ git checkout -b [BRANCH_NAME] [ORIGIN/BRANCH_NAME] 
    ```
1. 레파지토리 전체 브랜치에 대한 커밋 로그 확인
    ```
    $ git reflog -g
    ```
1. 과거 상태로 복원
    ```
    $ git reset --hard [HASH(COMMIT ID)]
    ```
1. 커밋의 코드만 원복
    ```
    $ git revert [HASH(COMMIT ID)]
    ```
1. 브랜치 머지 : 현재 브랜치에 SOURCE_BRANCH를 병합
    ```
    $ git merge [--no--ff] [SOURCE_BRANCH]
    ```
1. 머지시 충돌 해결방법
    ```
    Message.....
    <<<<<<< [COMMIT POINT]
    My Conflict Message Area
    =======
    SOURCE_BRANCH Conflict Message Area
    >>>>>>> [SOURCE_BRANCH]
    ```
    - `<<<<<<< [COMMIT POINT]`와 `=======` 사이 부분이 내가 작성한 내용, `=======`와 `>>>>>>> [SOURCE_BRANCH]` 부분이 머지하려는 브랜치가 가지고 있는 변경 내용입니다.  
    - 에디터를 열고 내용을 수정하여 `<<<<<<<   =======   >>>>>>>` 태그를 제거합니다.
    ```
    Message.....
    My Conflict Message Area
    SOURCE_BRANCH Conflict Message Area
    ```
    - 커밋 후 다시 머지를 시도합니다.
1. 다른 브랜치의 일부 커밋만 반영하고 싶을때 
    ```
    $ git cherry-pick [HASH(COMMIT ID)]
    ```
1. 커밋 메세지 수정
    ```
    $ git commit --amend
    ```
1. 커밋 로그 정리
    ```
    $ git rebase -i [HASH(COMMIT ID)]
    ```  
    - (EX. 예시)  
    
    ```
    $ git log --graph
    * commit b3e1c0a09e69248c8d2d94729bef90a8d1515e00 (HEAD -> master)
    | Author: dongseok lee 
    | Date:   Tue Sep 17 21:00:18 2019 +0900
    |
    |     add 2
    |
    * commit 718fca6bc3192b4b45542bc7ea73dee192c15727
    | Author: dongseok lee 
    | Date:   Tue Sep 17 21:00:08 2019 +0900
    |
    |     add 1
    |
    * commit be9444aa0a1c13a0bb200795ee631127a73eb84a
    Author: dongseok lee 
    Date:   Tue Sep 17 20:48:10 2019 +0900

        add readme
    ```
    ```
    $ git rebase -i be9444aa0a1c13a0bb200795ee631127a73eb84a
    ```
    ```bash
    pick 718fca6 add 1
    squash b3e1c0a add 2  # ---> change pick -> squash

    # Rebase be9444a..b3e1c0a onto be9444a (2 commands)
    #
    # Commands:
    # p, pick <commit> = use commit
    # r, reword <commit> = use commit, but edit the commit message
    # e, edit <commit> = use commit, but stop for amending
    # s, squash <commit> = use commit, but meld into previous commit
    # f, fixup <commit> = like "squash", but discard this commit's log message
    # x, exec <command> = run command (the rest of the line) using shell
    # b, break = stop here (continue rebase later with 'git rebase --continue')
    # d, drop <commit> = remove commit
    # l, label <label> = label current HEAD with a name
    # t, reset <label> = reset HEAD to a label
    # m, merge [-C <commit> | -c <commit>] <label> [# <oneline>]
    # .       create a merge commit using the original merge commit's
    # .       message (or the oneline, if no original merge commit was
    # .       specified). Use -c <commit> to reword the commit message.
    #
    # These lines can be re-ordered; they are executed from top to bottom.
    #
    # If you remove a line here THAT COMMIT WILL BE LOST.
    #
    # However, if you remove everything, the rebase will be aborted.
    #
    # Note that empty commits are commented out
    ```
    ```bash
    # This is a combination of 2 commits.
    # This is the 1st commit message:

    add 1

    # This is the commit message #2:

    add 2

    # Please enter the commit message for your changes. Lines starting
    # with '#' will be ignored, and an empty message aborts the commit.
    #
    # Date:      Tue Sep 17 21:00:08 2019 +0900
    #
    # interactive rebase in progress; onto be9444a
    # Last commands done (2 commands done):
    #    pick 718fca6 add 1
    #    squash b3e1c0a add 2
    # No commands remaining.
    # You are currently rebasing branch 'master' on 'be9444a'.
    #
    # Changes to be committed:
    #       modified:   README.md
    #
    ```
    ```
    $ git log --graph
    * commit a36eef2ed7084c41c94718aec779cf9c5e10030e (HEAD -> master)
    | Author: dongseok lee <ds0703.lee@samsung.com>
    | Date:   Tue Sep 17 21:00:08 2019 +0900
    |
    |     add 1
    |
    |     add 2
    |
    * commit be9444aa0a1c13a0bb200795ee631127a73eb84a
    Author: dongseok lee <ds0703.lee@samsung.com>
    Date:   Tue Sep 17 20:48:10 2019 +0900

        add readme
    ```
- 참고
    - [Github workflow](http://guides.github.com/introduction/flow/)  
    - [Pro git](http://git-scm.com/book/en/v2)  
    - [git-tips](http://github.com/git-tips/tips)  

### 커밋메세지 작성법
1. 커밋메세지 Style(영문작성 기준)
    - Subject와 Body는 한줄 비워 구분한다.
    - Subject 끝에 '.'를 쓰지 않는다.
    - 각 문단의 시작은 대문자로 시작한다.
    - Subject는 명령형으로 시작한다.
    - Subject 동사는 현재 시제로 사용한다.
    - 한 라인에 72 characters 이내로 작성한다.
    - body에는 '어떻게' 보다는 '무엇을','왜'에 초점을 맞춰 설명한다.
- 참고
    - [How to Write a Git Commit Message](http://chris.beams.io/posts/git-commit/)  
    - [Commit Message Guidelines](http://gist.github.com/robertpainsi/b632364184e70900af4ab688decf6f53)
    - https://meetup.toast.com/posts/106

### Git Commit 단위의 크기
- 커밋의 단위는 단일 기능, 단일 주제단위로
- 리뷰어가 한번에 리뷰가능한 단위로 작게 분리하는것이 좋습니다.
- Google 기준을 보면 하나의 리뷰에 10개미만의 파일, 파일당 평균 수정파일은 24 loc 

### 커밋메세지로 이슈 닫기
Pull request 설명이나 Commit Message에 아래의 Keyword를 포함시켜 깃허브 Isssue를 자동으로 Close할 수 있습니다.
- Pull request 설명이나 Commit Message에 "Keyword + #ISSUE_NUMBER"를 참조하면 이슈와 연관이 생성됩니다.
- 해당 Pull request 가 Default Branch로 Merge 되면 이슈가 자동으로 close됩니다.
    - close
    - closes
    - closed
    - fix
    - fixes
    - fixed
    - resolve
    - resolves
    - resolved
- 같은 레파지토리라면 ```Fixes #45 ``` 와 같은 방식으로
- 다른 레파지토리라면 ```username/repository#issue_number``` 와 같은 방식으로 
- 여러개의 이슈를 close할 경우에는 ```This closes #34, closes #23, and closes example_user/example_repo#42```
- 참고
    - [Closing issues using keywords](http://help.github.com/en/articles/closing-issues-using-keywords)

### Fork repository 에 origin repository 소스 맞추기
1. git remote 확인
    ```
    $ git remote -v
    origin  http://github.com/{my_username}/{fork_repository}.git (fetch)
    origin  http://github.com/{my_username}/{fork_repository}.git (push)
    ```
1. ```upstream``` 으로 git remote 추가
    ```
    $ git remote add upstream https://github.com/{origin_username}/{origin_repository}.git
    $ git remote -v
    origin  http://github.com/{my_username}/{fork_repository}.git (fetch)
    origin  http://github.com/{my_username}/{fork_repository}.git (push)
    upstream http://github.com/{origin_username}/{origin_repository}.git (fetch)
    upstream http://github.com/{origin_username}/{origin_repository}.git (push)
    ```
1. pull or fetch
    ```bash
    $ git pull upstream
    ## or 
    $ git fetch upstream
    ```
1. 로컬레파지토리 브랜치 확인
    ```
    $ git branch -a
    ```
1. 싱크맞출 레파지토리 체크아웃  
    ``` 
    $ git checkout -b [NEW_TARGET_LOCAL_BRANCH_NAME] origin/[ORIGIN_SOURCE_BRANCH_NAME]
    $ git checkout -b just-test origin/just-test
    ```
1. git branch 상태 확인
    ```
    $ git status
    On branch just-test
    Your branch is up to date with 'origin/just-test'.

    nothing to commit, working tree clean
    ```
1. merge 명령 실행
    ```
    $ git merge upstream/[UPSTREAM_SOURCE_BRANCH_NAME]
    $ git merge upstream/just-test
    ```
1. origin에 push
    ```
    $ git push origin
    ```
- 참고
    - [Configuring a remote for a fork](http://help.github.com/en/articles/configuring-a-remote-for-a-fork)  
    - [Syncing a fork](http://help.github.com/en/articles/syncing-a-fork)  

### Gist 활용
Gist는 샘플 소스코드 또는 다양한 메세지 등을 텍스트 형식으로 공유할때 사용하는 간단한 웹 어플리케이션입니다.
- 코드를 메모하는 경우
- 다른 사람에게 샘플코드를 보여주는 경우
- 특징
    - 다른사람과 샘플코드를 공유하기 편합니다.
    - 내장된 에디터를 활용하여 크드를 브라우저에서 간단히 작성할 수 있습니다.
    - 파일 버전 이력관리가 됩니다.
    - Git Repository 로 관리되므로 clone, fork가 가능합니다.
    - 공유한 상대와 댓글을 달며 소통할 수 있습니다.
    - 다양한 언어에 대하여 Syntax Highlight 기능을 지원합니다.
- Gist
    - 사내 GitHub Pages 생성시 : `http://code.sdsdev.co.kr/gist`  
    - public GitHub Pages 생성시 : `http://gist.github.com`
- Your Gist
    - 사내 GitHub Pages 생성시 : `http://code.sdsdev.co.kr/gist/{username}`  
    - public GitHub Pages 생성시 : `http://gist.github.com/{username}`
- 참고
    - [Creating gists](http://help.github.com/en/articles/creating-gists)  

### GitHub Pages 활용
- GitHub Pages를 이용하면 프로젝트의 웹사이트를 정적 HTML로 만들어서 공개할 수 있습니다.  
- 각 유저의 도메인을 할당하는 것도 가능합니다. 이러한 기능을 이용하여 공개된 블로그를 활용해 볼 수도 있습니다. 
- [Github Pages](http://pages.github.com/) 생성방법을 참고하세요
- GitHub Pages 서비스 되는 URL은 아래와 같습니다.
    - 사내 GitHub Pages 생성시 : `http://code.sdsdev.co.kr/pages/{username}/{username}.github.io/`  
    - public GitHub Pages 생성시 : `http://{username}.github.io`
- 참고
    - [Github Pages](http://pages.github.com/)
    - [GitHub Pages Basics](http://help.github.com/en/categories/github-pages-basics)  
    - [User, Organization, and Project Pages](http://help.github.com/en/articles/user-organization-and-project-pages)
