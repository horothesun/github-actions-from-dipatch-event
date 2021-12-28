# GitHub Actions from Jenkins

[![My action](https://github.com/horothesun/github-actions-from-jenkins/actions/workflows/my_action.yml/badge.svg)](https://github.com/horothesun/github-actions-from-jenkins/actions/workflows/my_action.yml)
[![My failing action](https://github.com/horothesun/github-actions-from-jenkins/actions/workflows/my_failing_action.yml/badge.svg)](https://github.com/horothesun/github-actions-from-jenkins/actions/workflows/my_failing_action.yml)

Trigger and wait for a GitHub Action workflow from a Jenkins pipeline.

## Details

Given the [API to trigger a GitHub Action](https://docs.github.com/en/rest/reference/actions#create-a-workflow-dispatch-event) doesn't return any identifier, the strategy adopted here is to generate a UUID from Jenkins, passing it to a standardised `inputs.trigger_id` field to the newly triggered GitHub Action.
The identifier is going to be used as a _workflow artifact name_, which will then be used to identify the _actual workflow run_ from Jenkins.
This will enable Jenkins to wait for the specific workflow run completion.
