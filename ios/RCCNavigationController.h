#import <UIKit/UIKit.h>
#import "RCTBridge.h"

@interface RCCNavigationController : UINavigationController

- (instancetype)initWithProps:(NSDictionary *)props children:(NSArray *)children bridge:(RCTBridge *)bridge;
- (void)performAction:(NSString*)performAction actionParams:(NSDictionary*)actionParams bridge:(RCTBridge *)bridge;

@end
