package com.adanac.demo.bootstrap.service.pubapply;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adanac.demo.bootstrap.entity.pubapply.PubApplyDto;
import com.adanac.demo.bootstrap.entity.pubapply.PubApplyQueryDto;
import com.adanac.framework.log.MyLogger;
import com.adanac.framework.log.MyLoggerFactory;
import com.adanac.framework.page.Pager;
import com.adanac.framework.utils.DateUtils;

@Service(value = "pubApplyService")
public class PubApplyServiceImpl implements PubApplyService {

	private static final MyLogger log = MyLoggerFactory.getLogger(PubApplyServiceImpl.class);

	private List<PubApplyDto> pubApplyList;
	private Pager<PubApplyDto> pubApplyPager;

	@Override
	public Pager<PubApplyDto> queryPubApplyPage(PubApplyQueryDto query, Integer page, Integer paging) {
		if (pubApplyList == null) {
			pubApplyPager = initApply();
		}
		return pubApplyPager;
	}

	public Pager<PubApplyDto> initApply() {
		if (pubApplyPager == null) {
			pubApplyPager = initApplyPager();
		}
		return pubApplyPager;
	}

	private Pager<PubApplyDto> initApplyPager() {
		Pager<PubApplyDto> pager = new Pager<PubApplyDto>();
		if (pubApplyList == null) {
			pubApplyList = getPubApplyList();
		}
		pager.setDatas(pubApplyList);
		pager.setTotalDataCount(pubApplyList.size());
		return pager;
	}

	private List<PubApplyDto> getPubApplyList() {
		log.info("PubApplyServiceImpl====>getPubApplyList====>:");
		try {

			List<PubApplyDto> list = new ArrayList<PubApplyDto>();
			String today = DateUtils.format(new Date(), "yyyy-MM-dd");
			for (int i = 0; i < 20; i++) {
				PubApplyDto pubApply = new PubApplyDto();
				pubApply.setNumber(String.format("%02d", i + 1));
				if (i % 2 == 0) {
					pubApply.setApplyName("微信公众号");
					pubApply.setApplyDate(today);
					pubApply.setStatus("2");
					pubApply.setRejectReason("没有资质");
					pubApply.setOperation("<span class='glyphicon glyphicon-edit'></span>");
				} else {
					pubApply.setApplyName("会员中心");
					pubApply.setApplyDate(today);
					pubApply.setStatus("1");
					pubApply.setRejectReason("");
					pubApply.setOperation("<span class='glyphicon glyphicon-edit'></span>");
				}
				list.add(pubApply);
			}
			return list;
		} catch (Exception e) {
			log.error("bug====>:" + e.toString());
		}
		return null;
	}
}
