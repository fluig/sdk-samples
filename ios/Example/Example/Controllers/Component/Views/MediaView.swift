//
//  MediaView.swift
//  Example
//
//  Created by Gregory Sholl e Santos on 07/03/18.
//  Copyright © 2018 fluig SDK. All rights reserved.
//

import UIKit
import fluigSDKUi

class MediaView: UIView {

    let component = FluigSDKMediaView()
    
    init() {
        super.init(frame: .zero)
        setupView()
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        setupView()
    }
    
    deinit {
        component.stopVideo()
    }
}

// MARK: - Layout

extension MediaView {
    
    private func setupView() {
        backgroundColor = .white
        translatesAutoresizingMaskIntoConstraints = false
        
        setupComponent()
        setupTextView()
    }
    
    private func setupComponent() {
        component.videoUrl = Bundle.main.url(forResource: "video_background",
                                             withExtension: "mp4")
        component.translatesAutoresizingMaskIntoConstraints = false
        component.playVideo()
        
        addSubview(component)
        
        NSLayoutConstraint.activate([
            component.topAnchor.constraint(equalTo: topAnchor),
            component.leadingAnchor.constraint(equalTo: leadingAnchor),
            component.trailingAnchor.constraint(equalTo: trailingAnchor),
            component.bottomAnchor.constraint(equalTo: bottomAnchor)
        ])
    }
    
    private func setupTextView() {
        let textView = UITextView()
        textView.text = """
        mediaView.videoUrl = Bundle.main.url(forResource: "video_background",
                                             withExtension: "mp4")
        """
        textView.textColor = .black
        textView.font = UIFont(name: "Menlo", size: 17.0)
        textView.isEditable = false
        textView.translatesAutoresizingMaskIntoConstraints = false
        
        addSubview(textView)
        
        NSLayoutConstraint.activate([
            textView.topAnchor.constraint(equalTo: bottomAnchor,
                                          constant: 16.0),
            textView.leadingAnchor.constraint(equalTo: leadingAnchor,
                                              constant: 16.0),
            textView.trailingAnchor.constraint(equalTo: trailingAnchor,
                                               constant: -16.0),
            textView.bottomAnchor.constraint(equalTo: bottomAnchor,
                                             constant: 16.0)
        ])
    }
}
