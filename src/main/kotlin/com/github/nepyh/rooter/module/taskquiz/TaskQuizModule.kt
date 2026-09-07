package com.github.nepyh.rooter.module.taskquiz

import com.github.nepyh.rooter.common.config.AppConfig
import com.github.nepyh.rooter.module.scheduler.SchedulerJob
import com.github.nepyh.rooter.module.taskquiz.api.TaskQuizApi
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun TaskQuizModule(appConfig: AppConfig) = module {
    single { TaskQuizLlmClient(appConfig) }
    single { TaskQuizService(get()) }
    single<SchedulerJob> { TaskQuizTriggerJob(get()) }

    single(named("taskQuizApi")) { TaskQuizApi(get()) }
}
