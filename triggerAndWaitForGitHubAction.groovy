folder('experimental') {
    displayName('experimental')
    description('experimental jobs')
}

pipelineJob('experimental/Trigger and wait for a GitHub Action') {
    logRotator {
        numToKeep(20)
    }
    parameters {
        stringParam('JENKINSFILE_BRANCH', 'master', 'Required')
        stringParam('REPO_OWNER', 'horothesun', 'Required')
        stringParam('REPO_NAME', 'github-actions-from-dipatch-event', 'Required')
        stringParam('REPO_REF', 'master', 'Required. The git reference for the workflow. The reference can be a branch or tag name.')
        stringParam('GITHUB_ACTION_FILE_NAME', 'my_action.yml', 'Required')
    }
    definition {
        cpsScm {
            scm{
                git {
                    remote {
                        url('https://github.com/horothesun/github-actions-from-dipatch-event.git')
                        credentials('GITHUB_PRIVATE_REPOS_CREDENTIALS')
                    }
                    branches('*/${JENKINSFILE_BRANCH}')
                    scriptPath('triggerAndWaitForGitHubAction.jenkinsfile')
                }
            }
        }
    }
}
