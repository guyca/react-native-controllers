import React, {
  requireNativeComponent,
  Component,
  View,
  UIManager,
  findNodeHandle
} from 'react-native';

const AndroidAppbarLayout = requireNativeComponent('AppbarLayout', AppbarLayout);


class AppbarLayout extends Component {
  render() {
    return (
      <AndroidAppbarLayout
        {...this.props}
        style={[{flex: 1}, this.props.style]}>
      </AndroidAppbarLayout>
    );
  }
}

module.exports = AppbarLayout;
