package com.xizhi.system.feign.factory;

import org.springframework.stereotype.Component;

import com.xizhi.system.domain.SysDept;
import com.xizhi.system.feign.RemoteDeptService;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RemoteDeptFallbackFactory implements FallbackFactory<RemoteDeptService>
{/* (non-Javadoc)
  * @see feign.hystrix.FallbackFactory#create(java.lang.Throwable)
  */
    @Override
    public RemoteDeptService create(Throwable throwable)
    {
        log.error(throwable.getMessage());
        return new RemoteDeptService()
        {

            @Override
            public SysDept selectSysDeptByDeptId(long deptId)
            {
                return null;
            }
        };
    }
}
