import React, {
  Component,
  processColor,
  PropTypes,
  View,
  UIManager,
  findNodeHandle,
  requireNativeComponent
} from 'react-native';

const AndroidTabLayout = requireNativeComponent('TabLayout', TabLayout);

class TabLayout extends Component {
  static propTypes = {
    ...View.propTypes,
    onTabSelected: PropTypes.func,
    selectedTab: PropTypes.number,
    selectedTabIndicatorColor: PropTypes.string,
    tabGravity: PropTypes.oneOf(['fill', 'center']),
    tabMode: PropTypes.oneOf(['fixed', 'scrollable'])
  };

  render() {
    return (
      <AndroidTabLayout
        {...this.props}
        selectedTabIndicatorColor={processColor(this.props.selectedTabIndicatorColor)}
        onTabSelected={this._onTabSelected}
        style={[{height: 48}, this.props.style]} />
    );
  }

  _onTabSelected = (e) => {
    if (this.props.onTabSelected) {
      this.props.onTabSelected(e);
    }
  };

  setViewPager(viewPager) {
    var viewPagerID = findNodeHandle(viewPager);

    UIManager.dispatchViewManagerCommand(
      React.findNodeHandle(this),
      UIManager.TabLayout.Commands.setViewPager,
      [viewPagerID, this.props.tabs]
    );
  }
}

module.exports = TabLayout;