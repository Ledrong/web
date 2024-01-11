package com.example.nepekariproject.config
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component


@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class DataSourceContextHolder {

    private final val threadLocal: ThreadLocal<DataSourceEnum> = ThreadLocal<DataSourceEnum>().apply { set( DataSourceEnum.DATA_SOURCE_UNKNOWN) }

    fun setContext(dataSourceEnum: DataSourceEnum) {
        threadLocal.set(dataSourceEnum)
    }

    fun getContext(): DataSourceEnum? {
        return threadLocal.get()
    }

    fun clearContext() {
        threadLocal.remove()
    }
}