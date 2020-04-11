# Developer Notes

## Package repository

The packages of this library are primarily hosted in the author's Bintray repository.
 
https://bintray.com/nyakamoto/maven/java-os-detector

For users who want to use this  without manually specifying the above repository,
the packages are linked to JCenter.

https://bintray.com/bintray/jcenter

## How to release

This sbt project uses [sbt-git](https://github.com/sbt/sbt-git) to determine the
version of this project. To release a new version of this plugin, follow the
instructions below.

### 1. Clean repository

Make sure that you do not have any unstaged changes in your git repository. Run

    $ git status

If you have any unstaged changes, commit or clean them.

### 2. Check the latest version

Run

    $ git tag
    
to see what versions have been released so far and determine the version of the
next release.

### 3. Add tag

Once you determine the version, run the command below to add a new tag.

    $ git tag -a "vx.y.z" -m "New release version x.y.z"

### 4. Create a repository on Bintray

(Skip this step if you already have "sbt-plugins" repository on Bintray.)

This project uses [sbt-bintray](https://github.com/sbt/sbt-bintray) plugin to publish
the packages to [Bintray](https://bintray.com/). If you have not created your account
on Bintray, create a free one.

If you have not created "maven" repository on your Bintray account yet, please 
first create it. When you create the repository, make sure that the name is
"maven" and type is "Maven".

### 5. Configure your Bintray credentials

(Skip this step if you have already configured your Bintray credentials.)

If have not configured your Bintray credentials in your computer, first you need
to get your API Key. Follow the steps below to do so.  

* Go to [your Bintray profile page](https://bintray.com/profile/edit).
* Click "API Key" in the left menu.
* If you are asked, re-enter your password of your Bintray account and press "Submit" button.
* Press "Show" link to show your API Key.
    
[sbt-bintray](https://github.com/sbt/sbt-bintray) plugin reads credential information
from `~/.bintray/.credentials`. If you have not created this file, create it with 
the following contents

    realm = Bintray API Realm
    host = api.bintray.com
    user = (your bintray user name)
    password = (your API Key)
    
Set your API Key to "password" field, not the password you enter when you login Bintray.

Finally, in this project directory, run
   
    $ sbt bintrayWhoami
    
to see if your Bintray user name is correctly loaded from the credential settings.

### 6. Publish to Bintray

Once the credential settings are completed, run the commands below in this project
directory to publish your new version.

    $ sbt publish
    $ sbt bintrayRelease
    
If these commands are successful, you should be able to see the new version of 
this package in your repository. You can see your new package here

     https://bintray.com/(your_account_name)/maven/java-os-detector
    
and

     https://dl.bintray.com/(your_account_name)/maven

### 7. Push git tag to github
   
Do not forget to push the newly created tag to github.

    $ git push  
    $ git push --tags

       
## References

* [Publishing an SBT Project onto Bintray: an Example](http://queirozf.com/entries/publishing-an-sbt-project-onto-bintray-an-example)
* [sbt-git-versioning](https://github.com/rallyhealth/sbt-git-versioning): This project does not use this sbt-git-versioning plugin, but its documentation includes useful information about how [sbt-git](https://github.com/sbt/sbt-git) determines the version.
