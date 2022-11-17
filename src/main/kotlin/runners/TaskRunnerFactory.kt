package engine.process_manager.runners


import tasks.Task
import tasks.implementations.ServiceTask


object TaskRunnerFactory {
    fun createFromTask(task: Task): TaskRunner {
        return when (task) {
            is ServiceTask -> ServiceTaskRunner(task = task)
            else -> UnimplementedTaskRunner(task = task)
//            else -> throw NotImplementedError("Not implemented for $task")
        }
    }

    infix fun fromTask(task: Task): TaskRunner {
        return createFromTask(task)
    }
}


interface TaskRunner {
    val task: Task
    suspend fun run()
}


class UnimplementedTaskRunner(override val task: Task) : TaskRunner {

    override suspend fun run() {

    }


}


class ServiceTaskRunner(override val task: ServiceTask) : TaskRunner {

    override suspend fun run() {


    }


}


