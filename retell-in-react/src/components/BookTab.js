import React, { Component } from 'react'
import Book from './Book'
import './BookTab.css'
import { Tabs, Row, Col } from 'antd';

const TabPane = Tabs.TabPane;

function generateBookRow(n) {
    var doms = [];
    for (var i = 0; i < n; i++) {
      doms.push(<Book />);
    }
return <div><Row>{doms.map((dom)=><Col span={4} key={i}>{dom}</Col>)}</Row><Row>{doms.map((dom)=><Col span={4} key={i}>{dom}</Col>)}</Row></div>;
}

class BookTab extends Component {
    render () {
        return (
            <div className='book-tab'>
                <Tabs
                  defaultActiveKey="1"
                  tabPosition='top'
                //   style={{ height: 220 }}
                >
                  <TabPane tab="Tab 1" key="1">
                    {generateBookRow(6)}
                  </TabPane>
                  <TabPane tab="Tab 2" key="2">
                    {generateBookRow(6)}
                  </TabPane>
                  <TabPane tab="Tab 3" key="3">
                    {generateBookRow(6)}
                  </TabPane>
                  <TabPane tab="Tab 4" key="4">
                    {generateBookRow(6)}
                  </TabPane>
                  <TabPane tab="Tab 5" key="5">
                    {generateBookRow(6)}
                  </TabPane>
                  <TabPane tab="Tab 6" key="6">
                    {generateBookRow(6)}
                  </TabPane>
                  <TabPane tab="Tab 7" key="7">
                    {generateBookRow(6)}
                  </TabPane>
                  <TabPane tab="Tab 8" key="8">
                    {generateBookRow(6)}
                  </TabPane>
                  <TabPane tab="Tab 9" key="9">
                    {generateBookRow(6)}
                  </TabPane>
                  <TabPane tab="Tab 10" key="10">
                    {generateBookRow(6)}
                  </TabPane>
                  <TabPane tab="Tab 11" key="11">
                    {generateBookRow(6)}
                  </TabPane>
                </Tabs>
            </div>
        )
    }
}

export default BookTab