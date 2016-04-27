package com.adanac.demo.bootstrap.service.pubapply;

import com.adanac.demo.bootstrap.entity.pubapply.PubApplyDto;
import com.adanac.demo.bootstrap.entity.pubapply.PubApplyQueryDto;
import com.adanac.framework.page.Pager;

/**
 * 服务申请查询接口
 * @author lfz
 * @version 1.0
 */
public interface PubApplyService {

	/**
	 * 分页查询服务申请信息列表
	 * @param pubApply
	 * @param page
	 * @param paging
	 * @return
	 */
	public Pager<PubApplyDto> queryPubApplyPage(PubApplyQueryDto query, Integer page, Integer paging);

	// /**
	// * 申请服务
	// *
	// * @param serviceApplyDto
	// * @return
	// */
	// BaseDto addServiceApply(ServiceApplyDto serviceApplyDto);
	//
	// /**
	// * 服务状态变更
	// * @param serviceApplyDto
	// * @return
	// */
	// BaseDto modServiceApplyStatus(ServiceApplyDto serviceApplyDto) throws
	// SysException;
	//
	// /**
	// * 申请服务查询
	// *
	// * @param param
	// * @param serviceApplyDto
	// * @return
	// */
	// Pager<ServiceApplyDto> queryServiceApplyList(PagerParam param,
	// ServiceApplyDto serviceApplyDto);
	//
	// /**
	// * 申请服务查询【单个记录】
	// *
	// * @param applyId
	// * @return
	// */
	// ServiceApplyDto getServiceApply(Long applyId);

}
