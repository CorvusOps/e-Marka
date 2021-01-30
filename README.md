# e-Marka
***
  The Electronic Grade Records System or simplified as the e-Marka aims to upgrade the NexGen Academy Inc.’s manual way of recording data, starting next academic year 2021-2022. A computerized system will be utilized to electronically store the data of the students and instructors of the school, such as student details, instructor details, sections, and grade records – i.e. written works, quarterly assessments, and performance tasks. Furthermore, the e-Record aims to eliminate errors for the grade computation of the students.
---
---
---
# Table of Contents
   1. Dependencies
   2. [How To](https://github.com/CorvusOps/RE-cord#how-to) 
      * [Use GitHub](https://github.com/CorvusOps/RE-cord#use-github)
         * [Fork](https://github.com/CorvusOps/RE-cord#forking)
           * [Cloning Repository](https://github.com/CorvusOps/RE-cord#cloning-repository)
         * [Branching](https://github.com/CorvusOps/RE-cord#branching)
         * [Commit](https://github.com/CorvusOps/RE-cord#commit)
         * [Requesting Pull Request](https://github.com/CorvusOps/RE-cord#requesting-pull-request)
  3. Documentation
---
---
---
## Dependencies
***


## How to
   TLDR: The stuff you need mostly in commiting in GitHub and other related questions.
    
   First is to make a folder /project (or a folder where you are convinient to put your project).
   Second is to Clone the forked repository in the desired directory/folder.
***
  ### Use GitHub
   The very first thing to do in this repository is to fork it, so you can have the copy of it on your own repository.
   #### Forking
   ![Forking](Images/Forking.PNG)
   To fork this repository, you need to be added as an __collaborators__.
      After you fork this repository, you will proceed in your repository.
   Copy it and clone it in the __Git Bash__ or __GitHub App__.
   
   Make sure that every update you did, after accepting the pull request, you will make a clean copy of the repository we have (will explain later in a meeting).
      
   ###### Cloning Repository
      
   Example for GitHub App: ` https://github.com/CorvusOps/RE-cord.git ` 
   
![Clone A Repository](/Images/CloneARepo.PNG)

   Example for Git Bash: ` git clone https://github.com/CorvusOps/RE-cord.git `
   > ps this will automatically copy the whole repository(RE-cord) in the desired directory/folder.
      
   #### Branching
   Before you do the codes, take not that you need to make another branch related to the work you were given.
![Git Branching](Images/GitBranching.PNG)

   Check your current branch: `git branch`
   Create a new branch: `git checkout -b <name>`
    
    > ps do a good naming convention in every branches
    > pps everytime you do a different code, you need to push 
    >     backward (e.g. go to the main) then create a new 
    >     branch so that the progress wont interfere to each other
    > ppps your naming convention would be <initial><project><task>
    >     (e.g. JOInterfaceLogIn) so we know what your are working for
   
   #### Commit
   After you done all the code yada yada and lets say "yay, its working", now is the time to commit your changes into the repository.
   
   ```
      git add <file you changed>
      git commit -m <message>
      git log // to check if you did not get another branch commit to keep track of your changes
      git push -u origin <branchname>
   ```
   
    > ps when adding, make sure that you add only the file that you've changed and not the entire yada yada that happen to be change, it will reflect on the pull request so beware commiting this mistake
    > pps when commiting the changes, make sure that your massage is good naming wise (e.g. `git commit -m "Add LogInPage.java" -m "you can also add another message that explains what you did like this").
    > ppps its a good practice to see your log every once in a while to see that the changes you did is not mistaken or something to minimize human error.
    > pppps lastly when you say push -u origin, it means that it will push it to the main repository and it will reflect as is, and the < branchname> is where the things youve changed.
   
   #### Requesting Pull Request
   
---
---
---
## Documentation
