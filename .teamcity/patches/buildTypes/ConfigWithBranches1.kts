package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with id = 'ConfigWithBranches1'
in the root project, and delete the patch script.
*/
create(DslContext.projectId, BuildType({
    id("ConfigWithBranches1")
    name = "config with branches1"

    artifactRules = """
        aaa.txt
        subdir1 => subdir1
        src => src
        New Text Document.txt
        *.html
    """.trimIndent()

    vcs {
        root(AbsoluteId("TestArtifacts_HttpsGithubComInnayanMyrepositoryRefsHeadsMaster"))
    }

    steps {
        maven {
            enabled = false
            goals = "package"
        }
    }

    cleanup {
        keepRule {
            id = "BUILD_EXT_1"
            keepAtLeast = builds(3)
            dataToKeep = everything()
            preserveArtifactsDependencies = true
        }
        disableKeepRule("BUILD_EXT_2")
        disableKeepRule("BUILD_EXT_3")
        disableKeepRule("BUILD_EXT_4")
        disableKeepRule("BUILD_EXT_5")
        keepRule {
            id = "BUILD_EXT_6"
            keepAtLeast = builds(51)
            dataToKeep = historyAndStatistics {
                preserveLogs = true
            }
            applyPerEachBranch = true
            preserveArtifactsDependencies = true
        }
        keepRule {
            id = "BUILD_EXT_7"
            keepAtLeast = builds(7)
            applyToBuilds {
                withTags = anyOf("test")
            }
            dataToKeep = everything()
            preserveArtifactsDependencies = true
        }
        keepRule {
            id = "BUILD_EXT_8"
            keepAtLeast = allBuilds()
            dataToKeep = everything()
            preserveArtifactsDependencies = true
        }
    }
}))
