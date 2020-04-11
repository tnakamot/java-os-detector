# Developer Notes

This is a developer's note for those develop and release this library.

## Package repository

The packages of this library are primarily hosted in the Sonatype OSS repository.

https://oss.sonatype.org/service/local/repositories/releases/content/com/github/tnakamot/java-os-detector/

which is synchronized to Maven Central

https://repo1.maven.org/maven2/com/github/tnakamot/java-os-detector/

## How to release

This sbt project uses
 
 * [sbt-pgp](https://github.com/sbt/sbt-pgp) to sign the artifacts.
 * [sbt-sonatype](https://github.com/xerial/sbt-sonatype) to upload products.
 * [sbt-release](https://github.com/sbt/sbt-release) to automate release procedure.

Release procedure is fully automated, but you need some one-time preparation on your 
development environment before releasing. The

### PGP Key Registration

If you have not created your PGP key pair (public and private), create one with
this command.

    $ gpg --gen-key
    
It interactively asks your information. Enter as instructed and finally enter
passphrase. If the key pair is successfully created, you can see the information
about the created keys as shown below

    $ gpg --list-keys
    
    /home/username/.gnupg/pubring.kbx
    ----------------------------------
    pub   rsa3072 yyyy-mm-dd [SC] [expires: yyyy-mm-dd]
          1234567890ABCDEF1234567890ABCDEF12345678
    uid           [ultimate] Your Name <your@email.address>
    sub   rsa3072 yyyy-mm-dd [E] [expires: yyyy-mm-dd]
    
Now register your key to sks-keyservers.net.

    $ gpg --keyserver hkp://pool.sks-keyservers.net --send-keys 1234567890ABCDEF1234567890ABCDEF12345678
    
### Create your Sonatype account

If you do not have your Sonatype account (JIRA account), create one following
the instruction below.

https://central.sonatype.org/pages/ossrh-guide.html#create-a-ticket-with-sonatype

### Get User Token

Once you create your account, login [Nexus Repository Manager](https://oss.sonatype.org/)
with the newly created account (the same name and password as JIRA).

Once logged in, click your account name on the top right corner and select "Profile".
In the top middle of the Profile page, click the dropdown box showing "Summary" and 
select "User Token". Then, press "Access User Token" button to show your username 
and password of the user token.

### Set up credentials

Create `~/.sbt/1.0/sonatype.sbt` with the contents below

    credentials += Credentials(Path.userHome / ".sbt" / "sonatype_credentials")
    
Then, create `~/.sbt/sonatype_credentials` with the contents below

    realm=Sonatype Nexus Repository Manager
    host=oss.sonatype.org
    user=<your username>
    password=<your password>

Here the user and password must be the same one as the user token obtained in
the previous section.

### Release 

The steps above are one-time thing. Once you have done in your development
environment, you do not have to repeat for every release.

Before you launch sbt shell, you need to set `GPG_TTY` environmental variable
as advised [here](https://github.com/sbt/sbt-pgp/issues/138#issuecomment-407519040).  

    $ export GPG_TTY=$(tty)
    
Then, run the command below in the project directory.

    $ sbt release 

It asks you to enter the version number to release and passphrase of the GPG
key. Then, it finally publishes the released version to Maven Central and pushes
the version tags to github. This process typically takes several minutes. Be
patient. Once done, check if the packages are uploaded to Maven Central.

https://repo1.maven.org/maven2/com/github/tnakamot/java-os-detector/

It typically takes several minutes after `sbt release` command is completed
until the packages appear in Maven Central. Again, be patient.

Also confirm that your release tags are pushed to github.

https://github.com/tnakamot/java-os-detector/releases
      
## References

* [Sonatype setup](https://www.scala-sbt.org/release/docs/Using-Sonatype.html)

