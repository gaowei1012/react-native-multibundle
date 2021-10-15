//
//  EventName.swift
//  myRN
//
//  Created by Soul on 2021/10/9.
//

import Foundation

class EventName : NSObject {
  
  // 检查更新开始
  static let CHECK_UPDATE_START = "CHECK_UPDATE_START"
  // 检查更新成功
  static let CHECK_UPDATE_SUCCESS = "CHECK_UPDATE_SUCCESS"
  // 检查更新失败
  static let CHECK_UPDATE_FAILURE = "CHECK_UPDATE_FAILURE"
  // 开始下载新的模块
  static let CHECK_UPDATE_DOWNLOAD_NEWS = "CHECK_UPDATE_DOWNLOAD_NEWS"
  // 下载新模块进度
  static let CHECK_UPDATE_DOWNLOAD_PROGRESS = "CHECK_UPDATE_DOWNLOAD_PROGRESS"
  // 下载新的模块成功
  static let CHECK_UPDATE_DOWNLOAD_NEWS_SUCCESS = "CHECK_UPDATE_DOWNLOAD_NEWS_SUCCESS"
  // 下载新的模块失败
  static let CHECK_UPDATE_DOWNLOAD_NEWS_FAILURE = "CHECK_UPDATE_DOWNLOAD_NEWS_FAILURE"
  // 应用新的模块成功
  static let CHECK_UPDATE_DOWNLOAD_NEWS_APPLY = "CHECK_UPDATE_DOWNLOAD_NEWS_APPLY"
  
}
