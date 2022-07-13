export enum EventName {
  CHECK_UPDATE_START = "CHECK_UPDATE_START",
  CHECK_UPDATE_SUCCESS = "CHECK_UPDATE_SUCCESS", // type NetWorkRsult
  CHECK_UPDATE_FAILURE = "CHECK_UPDATE_FAILURE", // errorMsg: string
  CHECK_UPDATE_DOWNLOAD_NEWS = "CHECK_UPDATE_DOWNLOAD_NEWS", // type Component
  CHECK_UPDATE_DOWNLOAD_PROGRESS = "CHECK_UPDATE_DOWNLOAD_PROGRESS", // { componentName: string, progress: number }
  CHECK_UPDATE_DOWNLOAD_NEWS_SUCCESS = "CHECK_UPDATE_DOWNLOAD_NEWS_SUCCESS", // type Component
  CHECK_UPDATE_DOWNLOAD_NEWS_FAILURE = "CHECK_UPDATE_DOWNLOAD_NEWS_FAILURE", // errorMsg: string
  CHECK_UPDATE_DOWNLOAD_NEWS_APPLY = "CHECK_UPDATE_DOWNLOAD_NEWS_APPLY", // componentName: string

  APP_ON_FRONT = "APP_ON_FRONT",
}
