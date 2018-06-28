package com.chenhongjuan.mavendemo;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
/*
 * author：陈红鹃
 * date:2018/6/24
 * version:1.1
 */

//主程序类
public class TencentPageProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(5).setSleepTime(1000);

	private static TencentPositionDao dao = new TencentPositionDaoImpl();

	public Site getSite() {
		return site;
	}

	public void process(Page page) {
		List<String> urlList = page.getHtml().links().regex("https://hr.tencent.com/position.php\\?&start=\\d+").all();
		System.out.println(urlList);
		page.addTargetRequests(urlList);

		List<String> positionNames = page.getHtml().xpath("//tr[@class='odd']/td[1]/a/text()").all();
		List<String> positionLinks = page.getHtml().xpath("//tr[@class='odd']/td[1]/a/@href").all();
		List<String> positionTypes = page.getHtml().xpath("//tr[@class='odd']/td[2]/text()").all();
		List<String> positionNums = page.getHtml().xpath("//tr[@class='odd']/td[3]/text()").all();
		List<String> workLocations = page.getHtml().xpath("//tr[@class='odd']/td[4]/text()").all();
		List<String> publishTimes = page.getHtml().xpath("//tr[@class='odd']/td[5]/text()").all();
		for (int i = 0; i < positionNames.size(); i++) {
			TencentPosition position = new TencentPosition();
			position.setPositionName(positionNames.get(i));
			position.setPositionLink(positionLinks.get(i));
			position.setPositionType(positionTypes.get(i));
			position.setPositionNum(positionNums.get(i));
			position.setPublishTime(publishTimes.get(i));
			position.setWorkLocation(workLocations.get(i));
			dao.add(position);
		}
	}

	//mian方法，程序入口
	public static void main(String[] args) {
		Spider.create(new TencentPageProcessor()).addUrl("https://hr.tencent.com/position.php?&start=0")
				.addPipeline(new JsonFilePipeline("web_code")).thread(100).run();
	}

}
