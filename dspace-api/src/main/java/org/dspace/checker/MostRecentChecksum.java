/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.checker;

import org.dspace.content.Bitstream;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Database entity representation of the most_recent_checksum table
 *
 * @author kevinvandevelde at atmire.com
 */
@Entity
@Table(name="most_recent_checksum")
public class MostRecentChecksum implements Serializable
{

    @Id
    @OneToOne
    @JoinColumn(name="bitstream_id", nullable = false)
    private Bitstream bitstream;

    @Column(name= "to_be_processed", nullable = false)
    private boolean toBeProcessed;

    @Column(name= "expected_checksum", nullable = false)
    private String expectedChecksum;

    @Column(name= "current_checksum", nullable = false)
    private String currentChecksum;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= "last_process_start_date", nullable = false)
    private Date processStartDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= "last_process_end_date", nullable = false)
    private Date processEndDate;

    @Column(name= "checksum_algorithm", nullable = false)
    private String checksumAlgorithm;

    @Column(name= "matched_prev_checksum", nullable = false)
    private boolean matchedPrevChecksum;

    @Transient
    private boolean infoFound;

    @Transient
    private boolean bitstreamFound;

    @OneToOne
    @JoinColumn(name= "result")
    private ChecksumResult checksumResult;

    public Bitstream getBitstream() {
        return bitstream;
    }

    void setBitstream(Bitstream bitstream) {
        this.bitstream = bitstream;
    }

    public boolean isToBeProcessed() {
        return toBeProcessed;
    }

    public void setToBeProcessed(boolean toBeProcessed) {
        this.toBeProcessed = toBeProcessed;
    }

    public String getExpectedChecksum() {
        return expectedChecksum;
    }

    public void setExpectedChecksum(String expectedChecksum) {
        this.expectedChecksum = expectedChecksum;
    }

    public String getCurrentChecksum() {
        return currentChecksum;
    }

    public void setCurrentChecksum(String currentChecksum) {
        this.currentChecksum = currentChecksum;
    }

    public Date getProcessStartDate() {
        return processStartDate;
    }

    public void setProcessStartDate(Date processStartDate) {
        this.processStartDate = processStartDate;
    }

    public Date getProcessEndDate() {
        return processEndDate;
    }

    public void setProcessEndDate(Date processEndDate) {
        this.processEndDate = processEndDate;
    }

    public String getChecksumAlgorithm() {
        return checksumAlgorithm;
    }

    public void setChecksumAlgorithm(String checksumAlgorithm) {
        this.checksumAlgorithm = checksumAlgorithm;
    }

    public boolean isMatchedPrevChecksum() {
        return matchedPrevChecksum;
    }

    public void setMatchedPrevChecksum(boolean matchedPrevChecksum) {
        this.matchedPrevChecksum = matchedPrevChecksum;
    }

    public ChecksumResult getChecksumResult() {
        return checksumResult;
    }

    public void setChecksumResult(ChecksumResult checksumResult) {
        this.checksumResult = checksumResult;
    }

    public boolean isInfoFound() {
        return infoFound;
    }

    public void setInfoFound(boolean infoFound) {
        this.infoFound = infoFound;
    }

    public boolean isBitstreamFound() {
        return bitstreamFound;
    }

    public void setBitstreamFound(boolean bitstreamFound) {
        this.bitstreamFound = bitstreamFound;
    }
}
