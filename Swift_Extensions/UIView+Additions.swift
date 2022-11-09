//
//  UIView+Additions.swift
//  Created by Joao Gabriel Silva on 01/10/17.
//

import Foundation

extension UIView {
    func round(corners: UIRectCorner, with cornerRadius: Int = 10, andSetBackgroundColor color: UIColor = .white) {
        let rectShape = CAShapeLayer()
        rectShape.bounds = self.frame
        rectShape.position = self.center
        rectShape.path = UIBezierPath(roundedRect: self.bounds, byRoundingCorners: corners, cornerRadii: CGSize(width: cornerRadius, height: cornerRadius)).cgPath
        
        self.layer.backgroundColor = color.cgColor
        self.layer.mask = rectShape
    }
}
